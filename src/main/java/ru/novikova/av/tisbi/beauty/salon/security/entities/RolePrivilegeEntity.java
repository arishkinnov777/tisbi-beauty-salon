package ru.novikova.av.tisbi.beauty.salon.security.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "role_privileges", schema = "salon")
public class RolePrivilegeEntity {
  @Id
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  private RoleEntity role;

  @ManyToOne
  private PrivilegeEntity privilege;
}
