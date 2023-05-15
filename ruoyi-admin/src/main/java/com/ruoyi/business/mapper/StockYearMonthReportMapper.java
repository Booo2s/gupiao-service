package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.StockYearMonthReport;

/**
 * 年度股票分析Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
public interface StockYearMonthReportMapper 
{
    /**
     * 查询年度股票分析
     * 
     * @param stockNo 年度股票分析主键
     * @return 年度股票分析
     */
    public StockYearMonthReport selectStockYearMonthReportByStockNo(String stockNo);

    /**
     * 查询年度股票分析列表
     * 
     * @param stockYearMonthReport 年度股票分析
     * @return 年度股票分析集合
     */
    public List<StockYearMonthReport> selectStockYearMonthReportList(StockYearMonthReport stockYearMonthReport);

    /**
     * 新增年度股票分析
     * 
     * @param stockYearMonthReport 年度股票分析
     * @return 结果
     */
    public int insertStockYearMonthReport(StockYearMonthReport stockYearMonthReport);

    /**
     * 修改年度股票分析
     * 
     * @param stockYearMonthReport 年度股票分析
     * @return 结果
     */
    public int updateStockYearMonthReport(StockYearMonthReport stockYearMonthReport);

    /**
     * 删除年度股票分析
     * 
     * @param stockNo 年度股票分析主键
     * @return 结果
     */
    public int deleteStockYearMonthReportByStockNo(String stockNo);

    /**
     * 批量删除年度股票分析
     * 
     * @param stockNos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockYearMonthReportByStockNos(String[] stockNos);
}
