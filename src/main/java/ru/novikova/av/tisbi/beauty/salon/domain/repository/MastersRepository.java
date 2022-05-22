package ru.novikova.av.tisbi.beauty.salon.domain.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.MastersEntity;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;

@Repository
public interface MastersRepository extends CrudRepository<MastersEntity, UUID> {

  @Query(value = "select m.* from salon.masters m "
      + "left join salon.master_services ms on m.id = ms.master_id "
      + "where ms.service_id = :serviceId", nativeQuery = true)
  List<MastersEntity> getAllByServiceId(@Param("serviceId") UUID serviceId);

  MastersEntity findByUser(UserEntity user);
}
