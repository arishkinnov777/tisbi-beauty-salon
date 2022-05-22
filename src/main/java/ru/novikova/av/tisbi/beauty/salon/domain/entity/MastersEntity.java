package ru.novikova.av.tisbi.beauty.salon.domain.entity;

import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;

@Data
@Entity
@Table(name = "masters", schema = "salon", catalog = "beauty_salon")
public class MastersEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Basic
  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "master")
  private List<MasterServicesEntity> masterServices;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;
}
