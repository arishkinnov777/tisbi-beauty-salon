package ru.novikova.av.tisbi.beauty.salon.domain.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.MasterServicesEntity;

@Repository
public interface MasterServicesRepository extends CrudRepository<MasterServicesEntity, UUID> {

}
