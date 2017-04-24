package com.diegorubin.datacenter.charts.domain;

import java.util.Map;

/**
 * Chart
 *
 * @author diegorubin
 */
public class Chart {

    private String name;
    private Map<String, Long> series;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Long> getSeries() {
        return series;
    }

    public void setSeries(Map<String, Long> series) {
        this.series = series;
    }
}
