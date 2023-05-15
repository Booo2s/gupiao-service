package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 年度股票分析对象 stock_year_month_report
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
public class StockYearMonthReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String stockNo;

    /** 汇总日期 */
    @Excel(name = "汇总日期")
    private String sumDate;

    /** 最大开盘价 */
    @Excel(name = "最大开盘价")
    private Long maxOpenPrice;

    /** 平均开盘价 */
    @Excel(name = "平均开盘价")
    private Long avgOpenPrice;

    /** 最小开盘价 */
    @Excel(name = "最小开盘价")
    private Long minOpenPrice;

    /** 最大收盘价 */
    @Excel(name = "最大收盘价")
    private Long maxClosePrice;

    /** 平均收盘价 */
    @Excel(name = "平均收盘价")
    private Long avgClosePrice;

    /** 最小收盘价 */
    @Excel(name = "最小收盘价")
    private Long minClosePrice;

    /** 最低价峰值 */
    @Excel(name = "最低价峰值")
    private Long maxMaxPrice;

    /** 最低价平均值 */
    @Excel(name = "最低价平均值")
    private Long avgMinPrice;

    /** 最低价低谷值 */
    @Excel(name = "最低价低谷值")
    private Long minMinPrice;

    /** 最大涨跌额 */
    @Excel(name = "最大涨跌额")
    private Long maxChangeAmount;

    /** 平均涨跌额 */
    @Excel(name = "平均涨跌额")
    private Long avgChangeAmount;

    /** 最小涨跌额 */
    @Excel(name = "最小涨跌额")
    private Long minChangeAmount;

    /** 最大涨跌幅% */
    @Excel(name = "最大涨跌幅%")
    private Long maxChangeRate;

    /** 平均涨跌幅% */
    @Excel(name = "平均涨跌幅%")
    private Float avgChangeRate;

    /** 最小涨跌幅% */
    @Excel(name = "最小涨跌幅%")
    private Long minChangeRate;

    /** 总成绩量（手） */
    @Excel(name = "总成绩量", readConverterExp = "手=")
    private Long sumTradingVolume;

    /** 总成交额（千元） */
    @Excel(name = "总成交额", readConverterExp = "千=元")
    private Long sumTradingAmount;

    /** 标记 */
    @Excel(name = "标记")
    private Long flag;

    public void setStockNo(String stockNo) 
    {
        this.stockNo = stockNo;
    }

    public String getStockNo() 
    {
        return stockNo;
    }
    public void setSumDate(String sumDate) 
    {
        this.sumDate = sumDate;
    }

    public String getSumDate() 
    {
        return sumDate;
    }
    public void setMaxOpenPrice(Long maxOpenPrice) 
    {
        this.maxOpenPrice = maxOpenPrice;
    }

    public Long getMaxOpenPrice() 
    {
        return maxOpenPrice;
    }
    public void setAvgOpenPrice(Long avgOpenPrice) 
    {
        this.avgOpenPrice = avgOpenPrice;
    }

    public Long getAvgOpenPrice() 
    {
        return avgOpenPrice;
    }
    public void setMinOpenPrice(Long minOpenPrice) 
    {
        this.minOpenPrice = minOpenPrice;
    }

    public Long getMinOpenPrice() 
    {
        return minOpenPrice;
    }
    public void setMaxClosePrice(Long maxClosePrice) 
    {
        this.maxClosePrice = maxClosePrice;
    }

    public Long getMaxClosePrice() 
    {
        return maxClosePrice;
    }
    public void setAvgClosePrice(Long avgClosePrice) 
    {
        this.avgClosePrice = avgClosePrice;
    }

    public Long getAvgClosePrice() 
    {
        return avgClosePrice;
    }
    public void setMinClosePrice(Long minClosePrice) 
    {
        this.minClosePrice = minClosePrice;
    }

    public Long getMinClosePrice() 
    {
        return minClosePrice;
    }
    public void setMaxMaxPrice(Long maxMaxPrice) 
    {
        this.maxMaxPrice = maxMaxPrice;
    }

    public Long getMaxMaxPrice() 
    {
        return maxMaxPrice;
    }
    public void setAvgMinPrice(Long avgMinPrice) 
    {
        this.avgMinPrice = avgMinPrice;
    }

    public Long getAvgMinPrice() 
    {
        return avgMinPrice;
    }
    public void setMinMinPrice(Long minMinPrice) 
    {
        this.minMinPrice = minMinPrice;
    }

    public Long getMinMinPrice() 
    {
        return minMinPrice;
    }
    public void setMaxChangeAmount(Long maxChangeAmount) 
    {
        this.maxChangeAmount = maxChangeAmount;
    }

    public Long getMaxChangeAmount() 
    {
        return maxChangeAmount;
    }
    public void setAvgChangeAmount(Long avgChangeAmount) 
    {
        this.avgChangeAmount = avgChangeAmount;
    }

    public Long getAvgChangeAmount() 
    {
        return avgChangeAmount;
    }
    public void setMinChangeAmount(Long minChangeAmount) 
    {
        this.minChangeAmount = minChangeAmount;
    }

    public Long getMinChangeAmount() 
    {
        return minChangeAmount;
    }
    public void setMaxChangeRate(Long maxChangeRate) 
    {
        this.maxChangeRate = maxChangeRate;
    }

    public Long getMaxChangeRate() 
    {
        return maxChangeRate;
    }
    public void setAvgChangeRate(Float avgChangeRate)
    {
        this.avgChangeRate = avgChangeRate;
    }

    public Float getAvgChangeRate()
    {
        return avgChangeRate;
    }
    public void setMinChangeRate(Long minChangeRate) 
    {
        this.minChangeRate = minChangeRate;
    }

    public Long getMinChangeRate() 
    {
        return minChangeRate;
    }
    public void setSumTradingVolume(Long sumTradingVolume) 
    {
        this.sumTradingVolume = sumTradingVolume;
    }

    public Long getSumTradingVolume() 
    {
        return sumTradingVolume;
    }
    public void setSumTradingAmount(Long sumTradingAmount) 
    {
        this.sumTradingAmount = sumTradingAmount;
    }

    public Long getSumTradingAmount() 
    {
        return sumTradingAmount;
    }
    public void setFlag(Long flag) 
    {
        this.flag = flag;
    }

    public Long getFlag() 
    {
        return flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockNo", getStockNo())
            .append("sumDate", getSumDate())
            .append("maxOpenPrice", getMaxOpenPrice())
            .append("avgOpenPrice", getAvgOpenPrice())
            .append("minOpenPrice", getMinOpenPrice())
            .append("maxClosePrice", getMaxClosePrice())
            .append("avgClosePrice", getAvgClosePrice())
            .append("minClosePrice", getMinClosePrice())
            .append("maxMaxPrice", getMaxMaxPrice())
            .append("avgMinPrice", getAvgMinPrice())
            .append("minMinPrice", getMinMinPrice())
            .append("maxChangeAmount", getMaxChangeAmount())
            .append("avgChangeAmount", getAvgChangeAmount())
            .append("minChangeAmount", getMinChangeAmount())
            .append("maxChangeRate", getMaxChangeRate())
            .append("avgChangeRate", getAvgChangeRate())
            .append("minChangeRate", getMinChangeRate())
            .append("sumTradingVolume", getSumTradingVolume())
            .append("sumTradingAmount", getSumTradingAmount())
            .append("flag", getFlag())
            .toString();
    }
}
