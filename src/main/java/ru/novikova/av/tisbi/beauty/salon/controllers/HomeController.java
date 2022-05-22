package ru.novikova.av.tisbi.beauty.salon.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.PageBreadcrumbs;
import ru.novikova.av.tisbi.beauty.salon.controllers.utils.PageParametersUtils;
import ru.novikova.av.tisbi.beauty.salon.domain.Service;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.ServicesRepository;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final ServicesRepository servicesRepository;

  @RequestMapping("/")
  public ModelAndView home() {
    Map<String, Object> params = new HashMap<>();

    List<Service> services = new ArrayList<>();
    servicesRepository.findAll().forEach(e ->
        services.add(Service.from(e, false))
    );

    PageParametersUtils.enableBreadcrumbs(PageBreadcrumbs.HOME, params);
    PageParametersUtils.fillUserDetails(params);

    params.put("headTitle", "Салон красоты");
    params.put("services", services);
    return new ModelAndView("index", params);
  }
}

