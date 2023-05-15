package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 股票交易信息对象 stock_info
 * 
 * @author hucc
 * @date 2023-02-17
 */
public class StockInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String stockNo;

    /** 交易日期 */
    @Excel(name = "交易日期")
    private String tradeDate;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private Long openPrice;

    /** 最高价 */
    @Excel(name = "最高价")
    private Long maxPrice;

    /** 最低价 */
    @Excel(name = "最低价")
    private Long minPrice;

    /** 收盘价 */
    @Excel(name = "收盘价")
    private Long closePrice;

    /** 昨收价 */
    @Excel(name = "昨收价")
    private Long yesterdayClosePrice;

    /** 涨跌额 */
    @Excel(name = "涨跌额")
    private Long changeAmount;

    /** 涨跌幅% */
    @Excel(name = "涨跌幅%")
    private Long changeRate;

    /** 成交量(手) */
    @Excel(name = "成交量(手)")
    private Long tradingVolume;

    /** 成交额(千元) */
    @Excel(name = "成交额(千元)")
    private Long tradingAmount;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date insertTime;

    /** 添加用户id */
    @Excel(name = "添加用户id")
    private Long addUserId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStockNo(String stockNo) 
    {
        this.stockNo = stockNo;
    }

    public String getStockNo() 
    {
        return stockNo;
    }
    public void setTradeDate(String tradeDate) 
    {
        this.tradeDate = tradeDate;
    }

    public String getTradeDate() 
    {
        return tradeDate;
    }
    public void setOpenPrice(Long openPrice) 
    {
        this.openPrice = openPrice;
    }

    public Long getOpenPrice() 
    {
        return openPrice;
    }
    public void setMaxPrice(Long maxPrice) 
    {
        this.maxPrice = maxPrice;
    }

    public Long getMaxPrice() 
    {
        return maxPrice;
    }
    public void setMinPrice(Long minPrice) 
    {
        this.minPrice = minPrice;
    }

    public Long getMinPrice() 
    {
        return minPrice;
    }
    public void setClosePrice(Long closePrice) 
    {
        this.closePrice = closePrice;
    }

    public Long getClosePrice() 
    {
        return closePrice;
    }
    public void setYesterdayClosePrice(Long yesterdayClosePrice) 
    {
        this.yesterdayClosePrice = yesterdayClosePrice;
    }

    public Long getYesterdayClosePrice() 
    {
        return yesterdayClosePrice;
    }
    public void setChangeAmount(Long changeAmount) 
    {
        this.changeAmount = changeAmount;
    }

    public Long getChangeAmount() 
    {
        return changeAmount;
    }
    public void setChangeRate(Long changeRate) 
    {
        this.changeRate = changeRate;
    }

    public Long getChangeRate() 
    {
        return changeRate;
    }
    public void setTradingVolume(Long tradingVolume) 
    {
        this.tradingVolume = tradingVolume;
    }

    public Long getTradingVolume() 
    {
        return tradingVolume;
    }
    public void setTradingAmount(Long tradingAmount) 
    {
        this.tradingAmount = tradingAmount;
    }

    public Long getTradingAmount() 
    {
        return tradingAmount;
    }
    public void setInsertTime(Date insertTime) 
    {
        this.insertTime = insertTime;
    }

    public Date getInsertTime() 
    {
        return insertTime;
    }
    public void setAddUserId(Long addUserId) 
    {
        this.addUserId = addUserId;
    }

    public Long getAddUserId() 
    {
        return addUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockNo", getStockNo())
            .append("tradeDate", getTradeDate())
            .append("openPrice", getOpenPrice())
            .append("maxPrice", getMaxPrice())
            .append("minPrice", getMinPrice())
            .append("closePrice", getClosePrice())
            .append("yesterdayClosePrice", getYesterdayClosePrice())
            .append("changeAmount", getChangeAmount())
            .append("changeRate", getChangeRate())
            .append("tradingVolume", getTradingVolume())
            .append("tradingAmount", getTradingAmount())
            .append("insertTime", getInsertTime())
            .append("updateTime", getUpdateTime())
            .append("addUserId", getAddUserId())
            .toString();
    }
}
