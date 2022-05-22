package ru.novikova.av.tisbi.beauty.salon.security.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.security.entities.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, UUID> {
  RoleEntity findByCode(String code);
}
