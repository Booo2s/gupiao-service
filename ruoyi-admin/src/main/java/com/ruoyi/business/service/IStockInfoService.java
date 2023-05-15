package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.StockInfo;

/**
 * 股票交易信息Service接口
 * 
 * @author hucc
 * @date 2023-02-17
 */
public interface IStockInfoService 
{
    /**
     * 查询股票交易信息
     * 
     * @param id 股票交易信息主键
     * @return 股票交易信息
     */
    public StockInfo selectStockInfoById(Long id);

    /**
     * 查询股票交易信息列表
     * 
     * @param stockInfo 股票交易信息
     * @return 股票交易信息集合
     */
    public List<StockInfo> selectStockInfoList(StockInfo stockInfo);

    /**
     * 新增股票交易信息
     * 
     * @param stockInfo 股票交易信息
     * @return 结果
     */
    public int insertStockInfo(StockInfo stockInfo);

    /**
     * 修改股票交易信息
     * 
     * @param stockInfo 股票交易信息
     * @return 结果
     */
    public int updateStockInfo(StockInfo stockInfo);

    /**
     * 批量删除股票交易信息
     * 
     * @param ids 需要删除的股票交易信息主键集合
     * @return 结果
     */
    public int deleteStockInfoByIds(Long[] ids);

    /**
     * 删除股票交易信息信息
     * 
     * @param id 股票交易信息主键
     * @return 结果
     */
    public int deleteStockInfoById(Long id);
}
