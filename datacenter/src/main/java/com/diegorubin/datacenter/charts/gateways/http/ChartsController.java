package com.diegorubin.datacenter.charts.gateways.http;

import com.diegorubin.datacenter.charts.domain.Chart;
import com.diegorubin.datacenter.charts.usecases.OrderChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Charts Controller
 *
 * @author diegorubin
 */
@RestController
@RequestMapping("/charts")
public class ChartsController {

    @Autowired
    private OrderChart orderChart;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Chart getOrderChart() {
        return orderChart.assemble();
    }
}
