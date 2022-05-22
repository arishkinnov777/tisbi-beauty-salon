package ru.novikova.av.tisbi.beauty.salon.controllers.constants;

public record Page(String href, String title, Boolean active) {

  public static Page notActive(String href, String title) {
    return new Page(href, title, false);
  }

  public static Page active(String title) {
    return new Page(null, title, true);
  }
}
