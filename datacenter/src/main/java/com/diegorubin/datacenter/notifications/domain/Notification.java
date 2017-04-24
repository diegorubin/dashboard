package com.diegorubin.datacenter.notifications.domain;

/**
 * Created by diegorubin on 24/04/17.
 */
public class Notification {
    private String chart;
    private Long value;
    private String point;

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
