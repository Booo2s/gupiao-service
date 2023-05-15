package com.ruoyi.business.controller;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.domain.*;
import com.ruoyi.business.service.IStockDecService;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysUserService;
import com.sun.jna.platform.unix.solaris.LibKstat;
import com.sun.jna.platform.win32.Netapi32Util;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.service.IStockInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

/**
 * 股票交易信息Controller
 * 
 * @author hucc
 * @date 2023-02-17
 */
@RestController
@RequestMapping("/business/stockinfo")
public class StockInfoController extends BaseController
{
    @Autowired
    private IStockInfoService stockInfoService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysNoticeService noticeService;
    @Autowired
    private IStockDecService stockDecService;
    /**
     * 首页菜单栏统计
     */
    @GetMapping(value = "/getindexcount")
    public AjaxResult getIndexCount()
    {
        int stockInfoCount=stockInfoService.selectStockInfoList(null).size();
        int stockDecCount=stockDecService.selectStockDecList(null).size();
        int usercount=userService.selectUserList(new SysUser()).size();
        int noticeCount=noticeService.selectNoticeList(null).size();

        IndexInfo indexInfo=new IndexInfo();
        indexInfo.setStockInfocount(stockInfoCount);
        indexInfo.setNoticecount(noticeCount);
        indexInfo.setStockDeccount(stockDecCount);
        indexInfo.setUsercount(usercount);
        return success(indexInfo);
    }
    /**
     * 股票总交易额柱状图
     */
    @GetMapping(value = "/getbarchart")
    public AjaxResult getBarChart()
    {
        java.util.Map<String, List<StockInfo>> groupStock=stockInfoService.selectStockInfoList(null).stream().collect(Collectors.groupingBy(StockInfo::getStockNo));
        List<String> xaxis=new ArrayList<>();
        List<Long>yaxis=new ArrayList<>();

        groupStock.forEach((key,value)->{
            xaxis.add(key);
            yaxis.add(value.stream().collect(Collectors.summingLong(StockInfo::getTradingAmount)));
        });
        BarChart barChart=new BarChart();
        barChart.setXaxis(xaxis);
        barChart.setYaxis(yaxis);
        return success(barChart);
    }
    /**
     * 股票交易数量饼图
     */
    @GetMapping(value = "/getpiechart")
    public AjaxResult getPieChart()
    {
        java.util.Map<String, List<StockInfo>> groupStock=stockInfoService.selectStockInfoList(null).stream().collect(Collectors.groupingBy(StockInfo::getStockNo));
        List<PieChart> list=new ArrayList<>();
        groupStock.forEach((key,value)->{
            PieChart pieChart=new PieChart();
            pieChart.setName(key);
            pieChart.setValue(value.stream().collect(Collectors.summingLong(StockInfo::getTradingVolume)));
            list.add(pieChart);
        });
        return success(list);
    }
    /**
     * 股票走势折线图
     */
    @GetMapping(value = "/getlinechart")
    public AjaxResult getlinechart()
    {
        StockInfo stockInfo=new StockInfo();
        stockInfo.setStockNo("600662.SH");
        java.util.Map<String, List<StockInfo>> groupStock=stockInfoService.selectStockInfoList(stockInfo).stream().collect(Collectors.groupingBy(StockInfo::getStockNo));
        List<LineChart> list=new ArrayList<>();
        groupStock.forEach((key,value)->{
            value.sort(Comparator.comparing(StockInfo::getTradeDate));
            List<String> dates=value.stream().map(StockInfo::getTradeDate).collect(Collectors.toList());
            List<Long> opens=value.stream().map(StockInfo::getOpenPrice).collect(Collectors.toList());
            List<Long> close=value.stream().map(StockInfo::getClosePrice).collect(Collectors.toList());
            LineChart lineChart=new LineChart();
            lineChart.setChartname(key);
            lineChart.setOpens(opens);
            lineChart.setCloses(close);
            lineChart.setDates(dates);
            list.add(lineChart);
        });
        return success(list);
    }

    /**
     * 查询股票交易信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stockinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockInfo stockInfo)
    {
        startPage();
        List<StockInfo> list = stockInfoService.selectStockInfoList(stockInfo);
        return getDataTable(list);
    }

    /**
     * 导出股票交易信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stockinfo:export')")
    @Log(title = "股票交易信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockInfo stockInfo)
    {
        List<StockInfo> list = stockInfoService.selectStockInfoList(stockInfo);
        ExcelUtil<StockInfo> util = new ExcelUtil<StockInfo>(StockInfo.class);
        util.exportExcel(response, list, "股票交易信息数据");
    }

    /**
     * 获取股票交易信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stockInfoService.selectStockInfoById(id));
    }

    /**
     * 新增股票交易信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockinfo:add')")
    @Log(title = "股票交易信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockInfo stockInfo)
    {
        return toAjax(stockInfoService.insertStockInfo(stockInfo));
    }

    /**
     * 修改股票交易信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockinfo:edit')")
    @Log(title = "股票交易信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockInfo stockInfo)
    {
        return toAjax(stockInfoService.updateStockInfo(stockInfo));
    }

    /**
     * 删除股票交易信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockinfo:remove')")
    @Log(title = "股票交易信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stockInfoService.deleteStockInfoByIds(ids));
    }
}
