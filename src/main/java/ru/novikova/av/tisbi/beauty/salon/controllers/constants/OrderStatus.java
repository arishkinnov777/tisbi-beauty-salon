package ru.novikova.av.tisbi.beauty.salon.controllers.constants;

public enum OrderStatus {
  NEW("Новый"),
  STARTED("В работе"),
  DONE("Завершен"),
  CANCEL("Отменен"),
  ;

  private final String displayValue;

  OrderStatus(String displayValue) {
    this.displayValue = displayValue;
  }

  public String getDisplayValue() {
    return displayValue;
  }
}
