package ru.novikova.av.tisbi.beauty.salon.controllers.ajax;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novikova.av.tisbi.beauty.salon.domain.Master;
import ru.novikova.av.tisbi.beauty.salon.domain.Schedule;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.MastersRepository;
import ru.novikova.av.tisbi.beauty.salon.domain.repository.ScheduleRepository;

@Slf4j
@RestController
@RequestMapping("/ajax/master")
@RequiredArgsConstructor
public class MastersAjaxController {

  private final MastersRepository mastersRepository;
  private final ScheduleRepository scheduleRepository;

  @GetMapping(value = "/service/{serviceId}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<Master> getMastersByService(@PathVariable("serviceId") String serviceId) {
    return mastersRepository.getAllByServiceId(UUID.fromString(serviceId)).stream()
        .map(Master::from)
        .collect(Collectors.toList());
  }

  @GetMapping(value = "/{masterId}/schedule",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<Schedule> getMasterSchedule(@PathVariable("masterId") String masterId) {
    return scheduleRepository.findFreeSlotsByMasterId(
            UUID.fromString(masterId),
            Date.valueOf(LocalDate.now())
        ).stream()
        .map(Schedule::from)
        .collect(Collectors.toList());
  }

}
