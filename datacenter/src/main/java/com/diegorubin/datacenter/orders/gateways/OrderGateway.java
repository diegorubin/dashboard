package com.diegorubin.datacenter.orders.gateways;

import com.diegorubin.datacenter.orders.domain.Order;

import java.time.LocalDate;
import java.util.List;

/**
 * Order Gateway
 *
 * @author diegorubin
 */
public interface OrderGateway {

  /**
   * List all orders
   *
   * @return list of orders
   */
  List<Order> findAll(LocalDate date);

  /**
   * List the latest orders
   *
   * @return list of orders
   */
  List<Order> findLatestOrders();

  /**
   * List all orders by source
   *
   * @param source the worker
   *
   * @return list of orders by source
   */
  List<Order> findBySource(String source);

  /**
   * Create order
   *
   * @param order the order
   *
   * @return created order
   */
  Order create(Order order);

  Long countLatestHourOrders();

}
