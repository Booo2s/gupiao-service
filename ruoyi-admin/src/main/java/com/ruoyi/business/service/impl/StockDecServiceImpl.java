package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.StockDecMapper;
import com.ruoyi.business.domain.StockDec;
import com.ruoyi.business.service.IStockDecService;

/**
 * 股票信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
@Service
public class StockDecServiceImpl implements IStockDecService 
{
    @Autowired
    private StockDecMapper stockDecMapper;

    /**
     * 查询股票信息
     * 
     * @param id 股票信息主键
     * @return 股票信息
     */
    @Override
    public StockDec selectStockDecById(Long id)
    {
        return stockDecMapper.selectStockDecById(id);
    }

    /**
     * 查询股票信息列表
     * 
     * @param stockDec 股票信息
     * @return 股票信息
     */
    @Override
    public List<StockDec> selectStockDecList(StockDec stockDec)
    {
        return stockDecMapper.selectStockDecList(stockDec);
    }

    /**
     * 新增股票信息
     * 
     * @param stockDec 股票信息
     * @return 结果
     */
    @Override
    public int insertStockDec(StockDec stockDec)
    {
        stockDec.setCreateTime(DateUtils.getNowDate());
        return stockDecMapper.insertStockDec(stockDec);
    }

    /**
     * 修改股票信息
     * 
     * @param stockDec 股票信息
     * @return 结果
     */
    @Override
    public int updateStockDec(StockDec stockDec)
    {
        stockDec.setUpdateTime(DateUtils.getNowDate());
        return stockDecMapper.updateStockDec(stockDec);
    }

    /**
     * 批量删除股票信息
     * 
     * @param ids 需要删除的股票信息主键
     * @return 结果
     */
    @Override
    public int deleteStockDecByIds(Long[] ids)
    {
        return stockDecMapper.deleteStockDecByIds(ids);
    }

    /**
     * 删除股票信息信息
     * 
     * @param id 股票信息主键
     * @return 结果
     */
    @Override
    public int deleteStockDecById(Long id)
    {
        return stockDecMapper.deleteStockDecById(id);
    }
}
