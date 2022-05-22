package ru.novikova.av.tisbi.beauty.salon.security.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "role", schema = "salon")
public class RoleEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Basic
  @Column(name = "code", length = 100)
  private String code;

  @Basic
  @Column(name = "name", length = 1000)
  private String name;

  @OneToMany(mappedBy = "role")
  private List<RolePrivilegeEntity> rolePrivileges;

}
