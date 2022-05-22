package ru.novikova.av.tisbi.beauty.salon.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.MastersEntity;

public record Master(UUID id, String name, UserAccount userAccount, String description, List<Service> services, String statusActivate) {
  public static Master from(MastersEntity entity) {
    return new Master(
        entity.getId(),
        entity.getUser().getFullName() == null ? "" : entity.getUser().getFullName(),
        UserAccount.from(entity.getUser()),
        entity.getDescription(),
        entity.getMasterServices().stream()
            .map(s -> Service.from(s.getService(), true))
            .collect(Collectors.toList()),
        entity.getUser().isActive() ? "Да" : "Нет");
  }
}
