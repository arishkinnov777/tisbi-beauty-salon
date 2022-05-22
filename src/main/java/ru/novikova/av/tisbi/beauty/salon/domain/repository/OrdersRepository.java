package ru.novikova.av.tisbi.beauty.salon.domain.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.novikova.av.tisbi.beauty.salon.domain.entity.OrdersEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, UUID> {

  @Query("select o from OrdersEntity o order by o.id")
  List<OrdersEntity> findAllOrderById();

  OrdersEntity findByCodeOrderById(UUID fromString);

  @Modifying
  @Query(value = "delete from salon.orders o where o.schedule_id = :scheduleId", nativeQuery = true)
  void deleteBySchedule(@Param("scheduleId") UUID id);

}
