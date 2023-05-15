package com.ruoyi.business.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.domain.*;
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
import com.ruoyi.business.service.IStockYearMonthReportService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 年度股票分析Controller
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
@RestController
@RequestMapping("/business/monthreport")
public class StockYearMonthReportController extends BaseController
{
    @Autowired
    private IStockYearMonthReportService stockYearMonthReportService;
    /**
     * 本月股票跌幅最大TOP10
     */
    @GetMapping(value = "/getmonthtoplinechart")
    public AjaxResult getMonthTopLineChart()
    {
        StockYearMonthReport  stockYearMonthReport=new StockYearMonthReport();
        stockYearMonthReport.setFlag(Long.parseLong("2"));
        List<StockYearMonthReport>reportsList=stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport);
        reportsList.sort(Comparator.comparing(StockYearMonthReport::getSumDate).
                thenComparing(StockYearMonthReport::getAvgChangeRate).reversed());
        String maxMonth=reportsList.get(0).getSumDate();
        List<StockYearMonthReport>topList=reportsList.stream().filter(d->d.getSumDate().equals(maxMonth)&&d.getAvgChangeRate()<0).limit(10).collect(Collectors.toList());
        List<String> xaxis=topList.stream().map(StockYearMonthReport::getStockNo).collect(Collectors.toList());
        List<Float> yaxis=topList.stream().map(StockYearMonthReport::getAvgChangeRate).collect(Collectors.toList());
        List<Float> yaxisf=new ArrayList<>();
        yaxis.forEach(model->{
            yaxisf.add(model*-1);
        });
        LineChart2 lineChart=new LineChart2();
        lineChart.setChartname("");
        lineChart.setDates(xaxis);
        lineChart.setOpens(yaxisf);
        return success(lineChart);
    }
    /**
     * 本月股票涨幅TOP10
     */
    @GetMapping(value = "/getmonthtopbarchart")
    public AjaxResult getMonthTopBarChart()
    {
        StockYearMonthReport  stockYearMonthReport=new StockYearMonthReport();
        stockYearMonthReport.setFlag(Long.parseLong("2"));
        List<StockYearMonthReport>reportsList=stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport);
        reportsList.sort(Comparator.comparing(StockYearMonthReport::getSumDate).
                thenComparing(StockYearMonthReport::getAvgChangeRate).reversed());
        String maxMonth=reportsList.get(0).getSumDate();
        List<StockYearMonthReport>topList=reportsList.stream().filter(d->d.getSumDate().equals(maxMonth)&&d.getAvgChangeRate()>0).limit(10).collect(Collectors.toList());

        BarChart2 barChart=new BarChart2();
        List<String> xaxis=topList.stream().map(StockYearMonthReport::getStockNo).collect(Collectors.toList());
        List<Float> yaxis=topList.stream().map(StockYearMonthReport::getAvgChangeRate).collect(Collectors.toList());
        barChart.setXaxis(xaxis);
        barChart.setYaxis(yaxis );
        return success(barChart);
    }
    /**
     * 本月股票交易量TOP10
     */
    @GetMapping(value = "/getmonthtoppiechart")
    public AjaxResult getMonthTopPieChart()
    {
        StockYearMonthReport  stockYearMonthReport=new StockYearMonthReport();
        stockYearMonthReport.setFlag(Long.parseLong("2"));
        List<StockYearMonthReport>reportsList=stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport);
        reportsList.sort(Comparator.comparing(StockYearMonthReport::getSumDate)
                .thenComparing(StockYearMonthReport::getSumTradingVolume).reversed());
        String maxMonth=reportsList.get(0).getSumDate();
        List<StockYearMonthReport>topList=reportsList.stream().filter(d->d.getSumDate().equals(maxMonth)).limit(10).collect(Collectors.toList());

        List<PieChart>pieCharts=new ArrayList<>();
        topList.forEach(model->{
             PieChart pieChart=new PieChart();
             pieChart.setMonth(maxMonth);
             pieChart.setName(model.getStockNo());
             pieChart.setValue(model.getSumTradingVolume());
             pieCharts.add(pieChart);
        });
        return success(pieCharts);
    }
    /**
     * 股票年汇总柱状图
     */
    @GetMapping(value = "/getyearbarchart")
    public AjaxResult getYearBarChart()
    {
        StockYearMonthReport  stockYearMonthReport=new StockYearMonthReport();
        stockYearMonthReport.setStockNo("600814.SH");
        stockYearMonthReport.setFlag(Long.parseLong("1"));
        java.util.Map<String, List<StockYearMonthReport>> groupStock=stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport).stream().collect(Collectors.groupingBy(StockYearMonthReport::getStockNo));
        List<BarChart>list=new ArrayList<>();
        groupStock.forEach((key,value)->{
            value.sort(Comparator.comparing(StockYearMonthReport::getSumDate));
            List<String> xaxis=value.stream().map(StockYearMonthReport::getSumDate).collect(Collectors.toList());
            List<Long> yaxis=value.stream().map(StockYearMonthReport::getSumTradingVolume).collect(Collectors.toList());
            BarChart barChart=new BarChart();
            barChart.setXaxis(xaxis);
            barChart.setYaxis(yaxis);
            barChart.setName(key);
            list.add(barChart);
        });
        return success(list);
    }
    /**
     * 查询年度股票分析列表
     */
    @PreAuthorize("@ss.hasPermi('business:monthreport:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockYearMonthReport stockYearMonthReport)
    {
        startPage();
        List<StockYearMonthReport> list = stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport);
        return getDataTable(list);
    }

    /**
     * 导出年度股票分析列表
     */
    @PreAuthorize("@ss.hasPermi('business:monthreport:export')")
    @Log(title = "年度股票分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockYearMonthReport stockYearMonthReport)
    {
        List<StockYearMonthReport> list = stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport);
        ExcelUtil<StockYearMonthReport> util = new ExcelUtil<StockYearMonthReport>(StockYearMonthReport.class);
        util.exportExcel(response, list, "年度股票分析数据");
    }

    /**
     * 获取年度股票分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:monthreport:query')")
    @GetMapping(value = "/{stockNo}")
    public AjaxResult getInfo(@PathVariable("stockNo") String stockNo)
    {
        return success(stockYearMonthReportService.selectStockYearMonthReportByStockNo(stockNo));
    }

    /**
     * 新增年度股票分析
     */
    @PreAuthorize("@ss.hasPermi('business:monthreport:add')")
    @Log(title = "年度股票分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockYearMonthReport stockYearMonthReport)
    {
        return toAjax(stockYearMonthReportService.insertStockYearMonthReport(stockYearMonthReport));
    }

    /**
     * 修改年度股票分析
     */
    @PreAuthorize("@ss.hasPermi('business:monthreport:edit')")
    @Log(title = "年度股票分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockYearMonthReport stockYearMonthReport)
    {
        return toAjax(stockYearMonthReportService.updateStockYearMonthReport(stockYearMonthReport));
    }

    /**
     * 删除年度股票分析
     */
    @PreAuthorize("@ss.hasPermi('business:monthreport:remove')")
    @Log(title = "年度股票分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockNos}")
    public AjaxResult remove(@PathVariable String[] stockNos)
    {
        return toAjax(stockYearMonthReportService.deleteStockYearMonthReportByStockNos(stockNos));
    }
}
