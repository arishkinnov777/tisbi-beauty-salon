package ru.novikova.av.tisbi.beauty.salon.domain.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ScheduleEntity;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, UUID> {
  List<ScheduleEntity> findAllByMasterId(UUID masterId);
}
