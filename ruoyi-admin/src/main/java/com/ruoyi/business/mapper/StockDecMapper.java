package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.StockDec;

/**
 * 股票信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
public interface StockDecMapper 
{
    /**
     * 查询股票信息
     * 
     * @param id 股票信息主键
     * @return 股票信息
     */
    public StockDec selectStockDecById(Long id);

    /**
     * 查询股票信息列表
     * 
     * @param stockDec 股票信息
     * @return 股票信息集合
     */
    public List<StockDec> selectStockDecList(StockDec stockDec);

    /**
     * 新增股票信息
     * 
     * @param stockDec 股票信息
     * @return 结果
     */
    public int insertStockDec(StockDec stockDec);

    /**
     * 修改股票信息
     * 
     * @param stockDec 股票信息
     * @return 结果
     */
    public int updateStockDec(StockDec stockDec);

    /**
     * 删除股票信息
     * 
     * @param id 股票信息主键
     * @return 结果
     */
    public int deleteStockDecById(Long id);

    /**
     * 批量删除股票信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockDecByIds(Long[] ids);
}
