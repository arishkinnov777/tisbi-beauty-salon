package ru.novikova.av.tisbi.beauty.salon.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.ServiceEntity;

@Repository
public interface ServicesRepository extends CrudRepository<ServiceEntity, UUID> {

  @Modifying
  @Query(value = "delete from salon.master_services ms where ms.master_id = :masterId",
      nativeQuery = true)
  void deleteByMasterId(@Param("masterId") UUID id);

}
