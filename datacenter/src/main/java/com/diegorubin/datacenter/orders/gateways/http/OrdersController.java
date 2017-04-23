package com.diegorubin.datacenter.orders.gateways.http;

import com.diegorubin.datacenter.orders.domain.Order;
import com.diegorubin.datacenter.orders.usecases.OrderCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Orders Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

  @Autowired
  private OrderCrud orderCrud;

  @RequestMapping(method = RequestMethod.GET)
  public List<Order> getMessages(@RequestParam(value = "worker", required = false) String worker,
                                 @RequestParam(value = "day", required = false) String date) {
    LocalDate localDate = null;
    if (date != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      localDate = LocalDate.parse(date, formatter);
    }
    return orderCrud.findAll(worker, localDate);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Order create(@RequestBody Order order) {
    return orderCrud.create(order);
  }

}
