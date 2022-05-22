package ru.novikova.av.tisbi.beauty.salon.security.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;

public interface UserAccountRepository extends CrudRepository<UserEntity, UUID> {

  @Query("select u from UserEntity u "
      + "left join MastersEntity m on m.user.id = u.id "
      + "where u.username like :username and m.id is null")
  List<UserEntity> findAllByUsernameAvailableUser(@Param("username") String username);

  UserEntity findByUsername(String username);
}
