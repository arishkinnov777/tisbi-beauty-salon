package ru.novikova.av.tisbi.beauty.salon.domain.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Access;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;

@Data
@Accessors(chain = true)

@Entity
@Table(name = "orders", schema = "salon", catalog = "beauty_salon")
public class OrdersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Basic
  @Column(name = "code")
  private UUID code;

  @Basic
  @Column(name = "price")
  private Integer price;

  @Basic
  @Column(name = "status")
  private String status;

  @Basic
  @Column(name = "created_at")
  private Timestamp createdAt;

  @Basic
  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "schedule_id", referencedColumnName = "id")
  private ScheduleEntity schedule;

  @ManyToOne
  @JoinColumn(name = "service_id", referencedColumnName = "id")
  private ServiceEntity service;

}
