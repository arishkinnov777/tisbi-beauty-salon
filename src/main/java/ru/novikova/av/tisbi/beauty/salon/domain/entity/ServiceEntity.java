package ru.novikova.av.tisbi.beauty.salon.domain.entity;

import java.sql.Time;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "service", schema = "salon", catalog = "beauty_salon")
public class ServiceEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "description")
  private String description;

  @Basic
  @Column(name = "duration")
  private Time duration;

  @Basic
  @Column(name = "price")
  private Integer price;

}
