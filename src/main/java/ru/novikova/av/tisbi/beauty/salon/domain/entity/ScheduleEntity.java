package ru.novikova.av.tisbi.beauty.salon.domain.entity;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "schedule", schema = "salon", catalog = "beauty_salon")
public class ScheduleEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  private MastersEntity master;

  @ManyToOne
  private TimeslotEntity timeslot;

  @Basic
  @Column(name = "date_timeslot")
  private Date dateTimeslot;

  @Basic
  @Column(name = "is_reserved")
  private Boolean reserved;

}
