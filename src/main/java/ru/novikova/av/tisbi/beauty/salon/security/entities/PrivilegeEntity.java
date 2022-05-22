package ru.novikova.av.tisbi.beauty.salon.security.entities;

import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "privilege", schema = "salon")
public class PrivilegeEntity {
  @Id
  @Column(name = "id")
  private UUID id;

  @Basic
  @Column(name = "code", length = 100)
  private String code;

  @Basic
  @Column(name = "name", length = 1000)
  private String name;
}
