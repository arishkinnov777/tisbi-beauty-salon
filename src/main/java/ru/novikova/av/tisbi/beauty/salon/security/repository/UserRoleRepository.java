package ru.novikova.av.tisbi.beauty.salon.security.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserRoleEntity;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, UUID> {
  @Modifying
  @Query(value = "delete from salon.user_roles r where r.user_id = :userId",
      nativeQuery = true)
  void deleteByUserId(@Param("userId") UUID id);
}
