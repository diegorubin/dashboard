package com.diegorubin.datacenter.orders.gateways.mongo;

import com.diegorubin.datacenter.orders.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Order Repository
 *
 * @author diegorubin
 */
interface OrderRepository extends MongoRepository<Order, String> {

  List<Order> findBySourceOrderByReceivedInDesc(String source);

  @Query(value = "{'receivedIn': {'$gte': ?0, '$lte': ?1}}")
  List<Order> findByDate(LocalDateTime begin, LocalDateTime end);

}
