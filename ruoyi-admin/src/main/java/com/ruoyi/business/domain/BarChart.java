package com.ruoyi.business.domain;

import java.util.List;

public class BarChart {
    public List<String> xaxis;
    public List<Long> yaxis;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getXaxis() {
        return xaxis;
    }

    public void setXaxis(List<String> xaxis) {
        this.xaxis = xaxis;
    }

    public List<Long> getYaxis() {
        return yaxis;
    }

    public void setYaxis(List<Long> yaxis) {
        this.yaxis = yaxis;
    }
}
