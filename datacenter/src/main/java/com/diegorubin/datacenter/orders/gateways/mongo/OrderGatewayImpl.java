package com.diegorubin.datacenter.orders.gateways.mongo;

import com.diegorubin.datacenter.orders.domain.Order;
import com.diegorubin.datacenter.orders.gateways.OrderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Order gateway implementation
 *
 * @author diegorubin
 */
@Component
public class OrderGatewayImpl implements OrderGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll(LocalDate date) {
        if (date == null) {
            return orderRepository.findAll();
        }
        return orderRepository.findByDate(date.atStartOfDay(), date.plusDays(1).atStartOfDay());
    }

    @Override
    public List<Order> findLatestOrders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1);
        return orderRepository.findByDate(yesterday, now);
    }

    @Override
    public List<Order> findBySource(final String source) {
        return orderRepository.findBySourceOrderByReceivedInDesc(source);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Long countLatestHourOrders() {
        LocalDateTime begin = LocalDateTime.now().withMinute(0);
        return (long) orderRepository.findByDate(begin, begin.plusHours(1)).size();
    }

}
