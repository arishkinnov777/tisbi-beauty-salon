package ru.novikova.av.tisbi.beauty.salon.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.PageBreadcrumbs;
import ru.novikova.av.tisbi.beauty.salon.controllers.utils.PageParametersUtils;
import ru.novikova.av.tisbi.beauty.salon.domain.Order;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.OrdersEntity;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.OrdersRepository;

@Slf4j
@Controller
@RequestMapping("/master")
@RequiredArgsConstructor
public class MasterCabinetController {
  private final OrdersRepository ordersRepository;

  @RequestMapping("/")
  public ModelAndView home() {
    HashMap<String, Object> params = new HashMap<>();
    List<Order> orders = new ArrayList<>();

    ordersRepository.findAllOrderById()
        .forEach(o -> orders.add(Order.from(o)));

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.MASTER, params);
    PageParametersUtils.fillUserDetails(params);

    params.put("headTitle", "Салон красоты");
    params.put("hasOrders", !orders.isEmpty());
    params.put("orders", orders);
    return new ModelAndView("master-index", params);
  }

  @RequestMapping("/order/{orderCode}/new")
  public RedirectView todo(@PathVariable("orderCode") String orderCode) {
    OrdersEntity order = ordersRepository.findByCodeOrderById(UUID.fromString(orderCode));
    order.setStatus("NEW");
    ordersRepository.save(order);
    return new RedirectView("/master/");
  }

  @RequestMapping("/order/{orderCode}/start")
  public RedirectView start(@PathVariable("orderCode") String orderCode) {
    OrdersEntity order = ordersRepository.findByCodeOrderById(UUID.fromString(orderCode));
    order.setStatus("STARTED");
    ordersRepository.save(order);
    return new RedirectView("/master/");
  }

  @RequestMapping("/order/{orderCode}/finish")
  public RedirectView finish(@PathVariable("orderCode") String orderCode) {
    OrdersEntity order = ordersRepository.findByCodeOrderById(UUID.fromString(orderCode));
    order.setStatus("DONE");
    ordersRepository.save(order);
    return new RedirectView("/master/");
  }

  @RequestMapping("/order/{orderCode}/cancel")
  public RedirectView cancel(@PathVariable("orderCode") String orderCode) {
    OrdersEntity order = ordersRepository.findByCodeOrderById(UUID.fromString(orderCode));
    order.setStatus("CANCEL");
    ordersRepository.save(order);
    return new RedirectView("/master/");
  }

}
