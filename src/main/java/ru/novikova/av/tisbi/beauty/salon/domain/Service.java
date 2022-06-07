package ru.novikova.av.tisbi.beauty.salon.domain;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import ru.novikova.av.tisbi.beauty.salon.controllers.utils.DateTimeFormatUtils;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ServiceEntity;

public record Service(UUID id,
                      String title,
                      String description,
                      Time duration,
                      String durationFormatted,
                      Integer price,
                      boolean selected) {

  public static Service from(ServiceEntity entity, boolean selected) {
    return new Service(
        entity.getId(),
        entity.getName(),
        entity.getDescription(),
        entity.getDuration(),
        DateTimeFormatUtils.formatTime(entity.getDuration().toLocalTime()),
        entity.getPrice(),
        selected
    );
  }
}