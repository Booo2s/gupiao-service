package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 股票信息对象 stock_dec
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
public class StockDec extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String stockNo;

    /** 简介 */
    @Excel(name = "简介")
    private String stockInduction;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
    private String Celue1;
    private String Celue2;

    public String getCelue1() {
        return Celue1;
    }

    public void setCelue1(String celue1) {
        Celue1 = celue1;
    }

    public String getCelue2() {
        return Celue2;
    }

    public void setCelue2(String celue2) {
        Celue2 = celue2;
    }

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
    public void setStockInduction(String stockInduction) 
    {
        this.stockInduction = stockInduction;
    }

    public String getStockInduction() 
    {
        return stockInduction;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockNo", getStockNo())
            .append("stockInduction", getStockInduction())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
