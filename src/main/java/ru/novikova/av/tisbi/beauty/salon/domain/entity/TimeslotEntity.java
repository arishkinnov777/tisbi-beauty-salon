package ru.novikova.av.tisbi.beauty.salon.domain.entity;

import java.sql.Time;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "timeslot", schema = "salon", catalog = "beauty_salon")
public class TimeslotEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Basic
  @Column(name = "time_start")
  private Time timeStart;

  @Basic
  @Column(name = "time_stop")
  private Time timeStop;

}
