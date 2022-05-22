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
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

@Entity
@Table(name = "users", schema = "salon")
public class UserEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Basic
  @Column(name = "full_name")
  private String fullName;

  @Basic
  @Column(name = "username", length = 100, unique = true)
  private String username;

  @Basic
  @Column(name = "password", length = 100)
  private String password;

  @Basic
  @Column(name = "email")
  private String email;

  @Basic
  @Column(name = "phone", length = 11)
  private String phone;

  @Basic
  @Column(name = "active")
  private boolean active;

  @OneToMany(mappedBy = "user")
  private List<UserRoleEntity> userRoles;
}
