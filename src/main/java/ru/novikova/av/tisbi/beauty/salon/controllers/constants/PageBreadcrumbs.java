package ru.novikova.av.tisbi.beauty.salon.controllers.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public enum PageBreadcrumbs {
  HOME(Collections.singletonList(Page.active("Home"))),

  ORDER_CREATE(Arrays.asList(
      Page.notActive("/","Home"),
      Page.active("Новый заказ")
  )),

  ORDER_VIEW(Arrays.asList(
      Page.notActive("/","Home"),
      Page.active("Информация о заказе")
  )),

  MASTER(Arrays.asList(
      Page.notActive("/","Home"),
      Page.active("Заказы")
  )),

  ADMIN(Arrays.asList(
      Page.notActive("/","Home"),
      Page.active("Заказы")
  )),

  ADMIN_MASTERS(Arrays.asList(
      Page.notActive("/","Home"),
      Page.active("Мастера")
  )),

  ADMIN_MASTER_ADD(Arrays.asList(
      Page.notActive("/","Home"),
      Page.notActive("/admin/master","Мастера"),
      Page.active("Создание мастера")
  )),

  ADMIN_MASTER_EDIT(Arrays.asList(
      Page.notActive("/","Home"),
      Page.notActive("/admin/master","Мастера"),
      Page.active("Изменение мастера")
  )),
  ;

  private final List<Page> pages;

  PageBreadcrumbs(List<Page> pages) {
    this.pages = pages;
  }

}
