package com.ruoyi.business.domain;

import java.util.List;

public class BarChart2 {
    public List<String> xaxis;
    public List<Float> yaxis;
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

    public List<Float> getYaxis() {
        return yaxis;
    }

    public void setYaxis(List<Float> yaxis) {
        this.yaxis = yaxis;
    }
}
