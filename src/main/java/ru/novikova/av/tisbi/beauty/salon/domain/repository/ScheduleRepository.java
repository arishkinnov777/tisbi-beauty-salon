package ru.novikova.av.tisbi.beauty.salon.domain.repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ScheduleEntity;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, UUID> {

  @Query("select s from ScheduleEntity s "
      + "where s.master.id = :masterId and s.reserved = false and s.dateTimeslot >= :date")
  List<ScheduleEntity> findFreeSlotsByMasterId(@Param("masterId") UUID masterId, @Param("date") Date date);

  List<ScheduleEntity> findAllByMasterId(UUID masterUID);
}
