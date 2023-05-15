package com.ruoyi.business.domain;

import java.util.List;

public class LineChart {
    public List<String> dates;
    public List<Long> opens;
    public List<Long> closes;
    public String chartname;

    public String getChartname() {
        return chartname;
    }

    public void setChartname(String chartname) {
        this.chartname = chartname;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public List<Long> getOpens() {
        return opens;
    }

    public void setOpens(List<Long> opens) {
        this.opens = opens;
    }

    public List<Long> getCloses() {
        return closes;
    }

    public void setCloses(List<Long> closes) {
        this.closes = closes;
    }
}

