package ru.novikova.av.tisbi.beauty.salon.domain;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.OrderStatus;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.OrdersEntity;

public record Order(Integer id,
                    UUID code,
                    Service service,
                    Customer customer,
                    Schedule schedule,
                    String status,
                    Integer price,
                    Timestamp createdAt,
                    String formatedDateCreate,
                    Map<String, Boolean> state) {

  public static Order from(OrdersEntity entity) {
    return new Order(
        entity.getId(),
        entity.getCode(),
        Service.from(entity.getService(), false),
        Customer.from(entity.getUser()),
        Schedule.from(entity.getSchedule()),
        OrderStatus.valueOf(entity.getStatus()).getDisplayValue(),
        entity.getPrice(),
        entity.getCreatedAt(),
        entity.getCreatedAt().toLocalDateTime().format(
            DateTimeFormatter.ISO_DATE
        ),
        Collections.singletonMap(entity.getStatus(), true)
    );
  }
}
