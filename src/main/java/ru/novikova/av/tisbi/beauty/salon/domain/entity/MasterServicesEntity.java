package ru.novikova.av.tisbi.beauty.salon.domain.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "master_services", schema = "salon", catalog = "beauty_salon")
public class MasterServicesEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  private MastersEntity master;

  @ManyToOne
  private ServiceEntity service;
}
