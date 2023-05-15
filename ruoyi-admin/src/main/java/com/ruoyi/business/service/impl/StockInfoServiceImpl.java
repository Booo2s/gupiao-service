package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.StockInfoMapper;
import com.ruoyi.business.domain.StockInfo;
import com.ruoyi.business.service.IStockInfoService;

/**
 * 股票交易信息Service业务层处理
 * 
 * @author hucc
 * @date 2023-02-17
 */
@Service
public class StockInfoServiceImpl implements IStockInfoService 
{
    @Autowired
    private StockInfoMapper stockInfoMapper;

    /**
     * 查询股票交易信息
     * 
     * @param id 股票交易信息主键
     * @return 股票交易信息
     */
    @Override
    public StockInfo selectStockInfoById(Long id)
    {
        return stockInfoMapper.selectStockInfoById(id);
    }

    /**
     * 查询股票交易信息列表
     * 
     * @param stockInfo 股票交易信息
     * @return 股票交易信息
     */
    @Override
    public List<StockInfo> selectStockInfoList(StockInfo stockInfo)
    {
        return stockInfoMapper.selectStockInfoList(stockInfo);
    }

    /**
     * 新增股票交易信息
     * 
     * @param stockInfo 股票交易信息
     * @return 结果
     */
    @Override
    public int insertStockInfo(StockInfo stockInfo)
    {
        return stockInfoMapper.insertStockInfo(stockInfo);
    }

    /**
     * 修改股票交易信息
     * 
     * @param stockInfo 股票交易信息
     * @return 结果
     */
    @Override
    public int updateStockInfo(StockInfo stockInfo)
    {
        stockInfo.setUpdateTime(DateUtils.getNowDate());
        return stockInfoMapper.updateStockInfo(stockInfo);
    }

    /**
     * 批量删除股票交易信息
     * 
     * @param ids 需要删除的股票交易信息主键
     * @return 结果
     */
    @Override
    public int deleteStockInfoByIds(Long[] ids)
    {
        return stockInfoMapper.deleteStockInfoByIds(ids);
    }

    /**
     * 删除股票交易信息信息
     * 
     * @param id 股票交易信息主键
     * @return 结果
     */
    @Override
    public int deleteStockInfoById(Long id)
    {
        return stockInfoMapper.deleteStockInfoById(id);
    }
}
