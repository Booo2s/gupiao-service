package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.StockInfo;

/**
 * 股票交易信息Mapper接口
 * 
 * @author hucc
 * @date 2023-02-17
 */
public interface StockInfoMapper 
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
     * 删除股票交易信息
     * 
     * @param id 股票交易信息主键
     * @return 结果
     */
    public int deleteStockInfoById(Long id);

    /**
     * 批量删除股票交易信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockInfoByIds(Long[] ids);
}
