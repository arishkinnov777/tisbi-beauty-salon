package ru.novikova.av.tisbi.beauty.salon.domain;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
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
        entity.getDuration().toLocalTime().format(
            DateTimeFormatter.ISO_TIME
        ),
        entity.getPrice(),
        selected
    );
  }
}
