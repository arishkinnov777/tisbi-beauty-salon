package ru.novikova.av.tisbi.beauty.salon.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.OrderStatus;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.PageBreadcrumbs;
import ru.novikova.av.tisbi.beauty.salon.controllers.utils.PageParametersUtils;
import ru.novikova.av.tisbi.beauty.salon.domain.Master;
import ru.novikova.av.tisbi.beauty.salon.domain.Order;
import ru.novikova.av.tisbi.beauty.salon.domain.Service;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.OrdersEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ScheduleEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ServiceEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.MastersRepository;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.OrdersRepository;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.ScheduleRepository;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.ServicesRepository;
import ru.novikova.av.tisbi.beauty.salon.security.entities.RoleEntity;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserRoleEntity;
import ru.novikova.av.tisbi.beauty.salon.security.repository.RoleRepository;
import ru.novikova.av.tisbi.beauty.salon.security.repository.UserAccountRepository;
import ru.novikova.av.tisbi.beauty.salon.security.repository.UserRoleRepository;

@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  private final ServicesRepository servicesRepository;
  private final OrdersRepository ordersRepository;
  private final MastersRepository mastersRepository;
  private final ScheduleRepository scheduleRepository;
  private final UserAccountRepository userAccountRepository;
  private final UserRoleRepository userRoleRepository;
  private final RoleRepository roleRepository;

  @RequestMapping("/service/{service_id}")
  public ModelAndView serviceGetOrder(@PathVariable(name = "service_id") String serviceId) {
    Map<String, Object> params = new HashMap<>();

    Service service = Service.from(
        servicesRepository.findById(UUID.fromString(serviceId)).get(), false);
    List<Master> masters = mastersRepository.getAllByServiceId(UUID.fromString(serviceId)).stream()
        .map(Master::from)
        .collect(Collectors.toList());

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.ORDER_CREATE, params);
    PageParametersUtils.fillUserDetails(params);

    params.put("headTitle", "Салон красоты");
    params.put("service", service);
    params.put("masters", masters);
    return new ModelAndView("order-create", params);
  }

  @GetMapping("/{order_id}")
  public ModelAndView getOrder(@PathVariable(name = "order_id") String orderId) {
    Map<String, Object> params = new HashMap<>();

    Order order = Order.from(ordersRepository.findByCodeOrderById(UUID.fromString(orderId)));

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.ORDER_VIEW, params);
    PageParametersUtils.fillUserDetails(params);

    params.put("headTitle", "Салон красоты");
    params.put("order", order);
    return new ModelAndView("order-view", params);
  }

  @Transactional
  @PostMapping("/")
  public RedirectView create(HttpServletRequest request) {
    String serviceId = request.getParameter("service_id");
    String customerName = request.getParameter("customer_name");
    String customerEmail = request.getParameter("customer_email");
    String customerPhone = request.getParameter("customer_phone");
    String masterId = request.getParameter("master_id");
    String masterScheduleId = request.getParameter("master_schedule_id");
    log.info("Create order for service {}", serviceId);
    log.info("Customer {}, {}, {} - {} {}", customerName, customerEmail, customerPhone, masterId,
        masterScheduleId);

    ServiceEntity service = servicesRepository.findById(UUID.fromString(serviceId)).get();
    ScheduleEntity schedule = scheduleRepository.findById(UUID.fromString(masterScheduleId)).get();

    UserEntity user;
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    if (authentication != null) {
      Object principal = authentication.getPrincipal();
      UserDetails userDetails = principal instanceof UserDetails ? (UserDetails) principal : null;
      if (userDetails != null) {
        log.info(userDetails.getUsername());
        user = userAccountRepository.findByUsername(userDetails.getUsername());
      } else {
        user = createUser(customerName, customerEmail, customerPhone);
      }
    } else {
      user = createUser(customerName, customerEmail, customerPhone);
    }

    OrdersEntity order = new OrdersEntity()
        .setCode(UUID.randomUUID())
        .setService(service)
        .setPrice(service.getPrice())
        .setStatus(OrderStatus.NEW.name())
        .setUser(user)
        .setCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        .setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()))
        .setSchedule(schedule);

    ordersRepository.save(order);

    schedule.setReserved(true);
    scheduleRepository.save(schedule);

    return new RedirectView("/order/" + order.getCode());
  }

  private UserEntity createUser(String customerName, String customerEmail, String customerPhone) {

    UserEntity user = userAccountRepository.findByUsername(customerPhone);

    if (user != null) {
      return user;
    }

    user = new UserEntity()
        .setId(UUID.randomUUID())
        .setEmail(customerEmail)
        .setPhone(customerPhone)
        .setUsername(customerPhone)
        .setFullName(customerName)
        .setPassword("{noop}" + UUID.randomUUID())
        .setActive(true);
    userAccountRepository.save(user);
    RoleEntity role = roleRepository.findByCode("visitor");
    UserRoleEntity userRole = new UserRoleEntity();
    userRole.setId(UUID.randomUUID());
    userRole.setUser(user);
    userRole.setRole(role);
    userRoleRepository.save(userRole);
    return user;
  }
}
