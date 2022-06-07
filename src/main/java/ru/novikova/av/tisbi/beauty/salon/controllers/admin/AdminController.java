package ru.novikova.av.tisbi.beauty.salon.controllers.admin;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.PageBreadcrumbs;
import ru.novikova.av.tisbi.beauty.salon.controllers.utils.PageParametersUtils;
import ru.novikova.av.tisbi.beauty.salon.domain.Master;
import ru.novikova.av.tisbi.beauty.salon.domain.Order;
import ru.novikova.av.tisbi.beauty.salon.domain.Service;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.MasterServicesEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.MastersEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ScheduleEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ServiceEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.MasterServicesRepository;
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
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

  private final ServicesRepository servicesRepository;
  private final OrdersRepository ordersRepository;
  private final MastersRepository mastersRepository;
  private final MasterServicesRepository masterServicesRepository;
  private final ScheduleRepository scheduleRepository;
  private final UserAccountRepository userAccountRepository;
  private final UserRoleRepository userRoleRepository;
  private final RoleRepository roleRepository;

  @RequestMapping("/")
  public ModelAndView home() {
    HashMap<String, Object> params = new HashMap<>();

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.ADMIN, params);
    PageParametersUtils.fillUserDetails(params);

    List<Order> orders = new ArrayList<>();

    ordersRepository.getAllOrders()
        .forEach(o -> orders.add(Order.from(o)));

    params.put("headTitle", "Салон красоты");
    params.put("hasOrders", !orders.isEmpty());
    params.put("orders", orders);
    return new ModelAndView("admin-index", params);
  }

  @RequestMapping("/master/add")
  public ModelAndView renderUserForm() {
    HashMap<String, Object> params = new HashMap<>();

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.ADMIN_MASTER_ADD, params);
    PageParametersUtils.fillUserDetails(params);

    List<Service> services = new ArrayList<>();

    servicesRepository.findAll()
        .forEach(s -> services.add(Service.from(s, false)));

    params.put("headTitle", "Салон красоты");
    params.put("services", services);
    return new ModelAndView("admin-master-add", params);
  }

  @RequestMapping("/master/{masterId}/edit")
  public ModelAndView masterEdit(@PathVariable("masterId") String masterId) {
    HashMap<String, Object> params = new HashMap<>();

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.ADMIN_MASTER_EDIT, params);
    PageParametersUtils.fillUserDetails(params);

    Master master = mastersRepository.findById(UUID.fromString(masterId))
        .map(Master::from).get();

    List<Service> services = new ArrayList<>();

    servicesRepository.findAll()
        .forEach(s -> {
          boolean selected = false;
          for (Service service : master.services()) {
            if (service.id().equals(s.getId())) {
              selected = true;
              break;
            }
          }
          if (!selected) {
            services.add(Service.from(s, selected));
          }
        });

    params.put("headTitle", "Салон красоты");
    params.put("master", master);
    params.put("servicesSelected", master.services());
    params.put("services", services);
    return new ModelAndView("admin-master-edit", params);
  }

  @Transactional
  @PostMapping("/master/{masterId}/update")
  public RedirectView masterUpdateEdit(@PathVariable("masterId") String masterId, HttpServletRequest request) {

    String username =  request.getParameter("login");

    UserEntity user = getUser(request, username);

    MastersEntity master = mastersRepository.findById(UUID.fromString(masterId)).get();
    master.setDescription(request.getParameter("description"));
    master.setUser(user);
    mastersRepository.save(master);

    updateMasterServices(request, master);
    return new RedirectView("/admin/master");
  }

  @Transactional
  @RequestMapping("/master/{masterId}/delete")
  public RedirectView masterDelete(@PathVariable("masterId") String masterId) {
    UUID masterUID = UUID.fromString(masterId);
    MastersEntity master = mastersRepository.findById(masterUID).get();
    List<ScheduleEntity> masterSchedules = scheduleRepository.findAllByMasterId(masterUID);
    masterSchedules.forEach(s -> {
      ordersRepository.deleteBySchedule(s.getId());
      scheduleRepository.delete(s);
    });
    masterServicesRepository.deleteAll(master.getMasterServices());
    userRoleRepository.deleteByUserId(master.getUser().getId());
    userAccountRepository.delete(master.getUser());
    mastersRepository.delete(master);
    return new RedirectView("/admin/master");
  }

  @RequestMapping("/master")
  public ModelAndView getMasters() {
    HashMap<String, Object> params = new HashMap<>();

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.ADMIN_MASTERS, params);
    PageParametersUtils.fillUserDetails(params);

    List<Master> masters = new ArrayList<>();
    mastersRepository.findAll().forEach(
        entity -> masters.add(Master.from(entity))
    );
    params.put("headTitle", "Салон красоты");
    params.put("hasMasters", !masters.isEmpty());
    params.put("masters", masters);
    return new ModelAndView("admin-master-index", params);
  }

  @Transactional
  @PostMapping(value = "/master")
  public RedirectView createMaster(HttpServletRequest request) {

    String username =  request.getParameter("login");
    UserEntity user = getUser(request, username);

    MastersEntity master = mastersRepository.findByUser(user);
    if (master == null) {
      master = new MastersEntity();
      master.setId(UUID.randomUUID());
      master.setUser(user);
      master.setDescription(request.getParameter("description"));
    } else {
      master.setUser(user);
      master.setDescription(request.getParameter("description"));
    }
    mastersRepository.save(master);

    updateMasterServices(request, master);

    return new RedirectView("/admin/master");
  }

  private void updateMasterServices(HttpServletRequest request, MastersEntity master) {
    servicesRepository.deleteByMasterId(master.getId());
    Arrays.stream(request.getParameterValues("services")).forEach(
        s -> {
          ServiceEntity service = servicesRepository.findById(UUID.fromString(s)).get();
          MasterServicesEntity masterServices = new MasterServicesEntity();
          masterServices.setId(UUID.randomUUID());
          masterServices.setMaster(master);
          masterServices.setService(service);
          masterServicesRepository.save(masterServices);
        }
    );
  }

  private UserEntity getUser(HttpServletRequest request, String username) {
    UserEntity user = userAccountRepository.findByUsername(username);

    if (user == null) {
      user = new UserEntity()
          .setId(UUID.randomUUID())
          .setUsername(username)
          .setPassword("{noop}" + request.getParameter("password"))
          .setEmail(request.getParameter("email"))
          .setPhone(request.getParameter("phone"))
          .setFullName(request.getParameter("fullName"))
          .setActive(true);
    } else {
      user.setPassword("{noop}" + request.getParameter("password"));
      user.setFullName(request.getParameter("fullName"));
      user.setEmail(request.getParameter("email"));
      user.setPhone(request.getParameter("phone"));
      user.setActive(true);
    }

    userAccountRepository.save(user);
    RoleEntity role = roleRepository.findByCode("master");
    UserRoleEntity userRole = new UserRoleEntity();
    userRole.setId(UUID.randomUUID());
    userRole.setUser(user);
    userRole.setRole(role);

    userRoleRepository.deleteByUserId(user.getId());
    userRoleRepository.save(userRole);
    return user;
  }

}
