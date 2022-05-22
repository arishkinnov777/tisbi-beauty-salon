package ru.novikova.av.tisbi.beauty.salon.domain;

import java.util.UUID;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;

public record UserAccount (UUID id, String name, String username, String email, String phone) {
  public static UserAccount from(UserEntity entity) {
    return new UserAccount(
        entity.getId(),
        entity.getFullName() != null ? entity.getFullName() : "",
        entity.getUsername() != null ? entity.getUsername() : "",
        entity.getEmail() != null ? entity.getEmail() : "",
        entity.getPhone() != null ? entity.getPhone() : ""
    );
  }
}
