package ru.novikova.av.tisbi.beauty.salon.domain;

import java.sql.Date;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ScheduleEntity;

public record Schedule(UUID id,
                       Master master,
                       Date date,
                       String dateFormatted,
                       Time timeStart,
                       String timeStartFormatted,
                       Time timeStop,
                       Boolean isReserved) {

  public static Schedule from(ScheduleEntity entity) {
    return new Schedule(
        entity.getId(),
        Master.from(entity.getMaster()),
        entity.getDateTimeslot(),
        entity.getDateTimeslot().toLocalDate().format(
            DateTimeFormatter.ISO_LOCAL_DATE
        ),
        entity.getTimeslot().getTimeStart(),
        entity.getTimeslot().getTimeStart().toLocalTime().format(
            DateTimeFormatter.ISO_TIME
        ),
        entity.getTimeslot().getTimeStop(),
        entity.getReserved()
    );
  }
}
