package com.diegorubin.datacenter.orders.usecases;

import com.diegorubin.datacenter.notifications.domain.Notification;
import com.diegorubin.datacenter.notifications.gateways.NotifyClient;
import com.diegorubin.datacenter.orders.domain.Order;
import com.diegorubin.datacenter.orders.gateways.OrderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Order Crud Use Case
 *
 * @author diegorubin
 */
@Component
public class OrderCrud {

    private static final Logger LOGGER = Logger.getLogger(OrderCrud.class.getName());

    @Autowired
    private OrderGateway orderGateway;

    @Autowired
    private NotifyClient notifyClient;

    public List<Order> findAll(String source, LocalDate date) {
        List<Order> orders;
        if (Optional.ofNullable(source).isPresent()) {
            orders = orderGateway.findBySource(source);
        } else {
            orders = orderGateway.findAll(date);
        }

        return orders;
    }

    public Order create(Order order) {
        order.setReceivedIn(LocalDateTime.now());
        LOGGER.info("creating order code=" + order.getOrderCode());
        Order created = orderGateway.create(order);
        try {
            notifyClient.notify(getNotification());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return created;
    }

    private Notification getNotification() {
        Notification notification = new Notification();
        notification.setChart("orders");
        notification.setPoint("last");
        notification.setValue(orderGateway.countLatestHourOrders());
        return notification;
    }

}
