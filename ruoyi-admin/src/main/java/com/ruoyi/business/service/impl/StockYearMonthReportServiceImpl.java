package com.ruoyi.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.StockYearMonthReportMapper;
import com.ruoyi.business.domain.StockYearMonthReport;
import com.ruoyi.business.service.IStockYearMonthReportService;

/**
 * 年度股票分析Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
@Service
public class StockYearMonthReportServiceImpl implements IStockYearMonthReportService 
{
    @Autowired
    private StockYearMonthReportMapper stockYearMonthReportMapper;

    /**
     * 查询年度股票分析
     * 
     * @param stockNo 年度股票分析主键
     * @return 年度股票分析
     */
    @Override
    public StockYearMonthReport selectStockYearMonthReportByStockNo(String stockNo)
    {
        return stockYearMonthReportMapper.selectStockYearMonthReportByStockNo(stockNo);
    }

    /**
     * 查询年度股票分析列表
     * 
     * @param stockYearMonthReport 年度股票分析
     * @return 年度股票分析
     */
    @Override
    public List<StockYearMonthReport> selectStockYearMonthReportList(StockYearMonthReport stockYearMonthReport)
    {
        return stockYearMonthReportMapper.selectStockYearMonthReportList(stockYearMonthReport);
    }

    /**
     * 新增年度股票分析
     * 
     * @param stockYearMonthReport 年度股票分析
     * @return 结果
     */
    @Override
    public int insertStockYearMonthReport(StockYearMonthReport stockYearMonthReport)
    {
        return stockYearMonthReportMapper.insertStockYearMonthReport(stockYearMonthReport);
    }

    /**
     * 修改年度股票分析
     * 
     * @param stockYearMonthReport 年度股票分析
     * @return 结果
     */
    @Override
    public int updateStockYearMonthReport(StockYearMonthReport stockYearMonthReport)
    {
        return stockYearMonthReportMapper.updateStockYearMonthReport(stockYearMonthReport);
    }

    /**
     * 批量删除年度股票分析
     * 
     * @param stockNos 需要删除的年度股票分析主键
     * @return 结果
     */
    @Override
    public int deleteStockYearMonthReportByStockNos(String[] stockNos)
    {
        return stockYearMonthReportMapper.deleteStockYearMonthReportByStockNos(stockNos);
    }

    /**
     * 删除年度股票分析信息
     * 
     * @param stockNo 年度股票分析主键
     * @return 结果
     */
    @Override
    public int deleteStockYearMonthReportByStockNo(String stockNo)
    {
        return stockYearMonthReportMapper.deleteStockYearMonthReportByStockNo(stockNo);
    }
}
