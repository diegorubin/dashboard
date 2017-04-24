package com.diegorubin.datacenter.charts.usecases;

import com.diegorubin.datacenter.charts.domain.Chart;
import com.diegorubin.datacenter.orders.domain.Order;
import com.diegorubin.datacenter.orders.gateways.OrderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Order Chart
 *
 * @author diegorubin
 */
@Component
public class OrderChart {

    @Autowired
    private OrderGateway orderGateway;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");

    public Chart assemble() {
        final Map<String, Long> points = new LinkedHashMap<>();

        final Chart chart = new Chart();
        chart.setName("orders");

        final List<Order> orders = orderGateway.findLatestOrders();
        orders.forEach(order -> {
            String key = order.getReceivedIn().format(formatter);
            Long total = points.getOrDefault(key, 0L);
            points.put(key, ++total);
        });
        chart.setSeries(points);

        return chart;
    }
}
