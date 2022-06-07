package ru.novikova.av.tisbi.beauty.salon.controllers.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeFormatUtils {

  private static final DateTimeFormatter hoursFormat = DateTimeFormatter.ofPattern("HH");
  private static final DateTimeFormatter minutesFormat = DateTimeFormatter.ofPattern("mm");
  private static final DateTimeFormatter onlyMinutesFormat = DateTimeFormatter.ofPattern("mm м.");
  private static final DateTimeFormatter onlyHoursFormat = DateTimeFormatter.ofPattern("H ч.");
  private static final DateTimeFormatter hoursAndMinutesFormat = DateTimeFormatter.ofPattern("H ч. mm м.");

  private DateTimeFormatUtils(){}

  public static String formatTime(LocalTime time){
    int hours = Integer.parseInt(time.format(hoursFormat));
    int minutes = Integer.parseInt(time.format(minutesFormat));
    if (hours == 0 && minutes > 0) {
      return time.format(onlyMinutesFormat);
    } else if (hours > 0 && minutes == 0) {
      return time.format(onlyHoursFormat);
    } else if (hours > 0 && minutes > 0) {
      return time.format(hoursAndMinutesFormat);
    } else {
      return "Моментально";
    }
  }

}
