package ru.novikova.av.tisbi.beauty.salon.domain;

import java.util.UUID;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;

public record Customer(UUID id, String name, String email, String phone) {
  public static Customer from(UserEntity entity) {
    return new Customer(
        entity.getId(),
        entity.getFullName(),
        entity.getEmail(),
        entity.getPhone()
    );
  }
}
