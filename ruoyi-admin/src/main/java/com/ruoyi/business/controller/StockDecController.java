package com.ruoyi.business.controller;

import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.domain.StockYearMonthReport;
import com.ruoyi.business.service.IStockYearMonthReportService;
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
import com.ruoyi.business.domain.StockDec;
import com.ruoyi.business.service.IStockDecService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 股票信息Controller
 * 
 * @author ruoyi
 * @date 2023-02-17
 */
@RestController
@RequestMapping("/business/stockdec")
public class StockDecController extends BaseController
{
    @Autowired
    private IStockDecService stockDecService;
    @Autowired
    private IStockYearMonthReportService stockYearMonthReportService;

    /**
     * 查询股票信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stockdec:list')")
    @GetMapping("/list")
    public TableDataInfo list(StockDec stockDec)
    {
        startPage();
        List<StockDec> list = stockDecService.selectStockDecList(stockDec);
        list.forEach(model->{
            StockYearMonthReport stockYearMonthReport= new StockYearMonthReport();
            stockYearMonthReport.setStockNo(model.getStockNo());
            stockYearMonthReport.setFlag(Long.parseLong("2"));
            List<StockYearMonthReport> reports = stockYearMonthReportService.selectStockYearMonthReportList(stockYearMonthReport);
            reports.sort(Comparator.comparing(StockYearMonthReport::getSumDate).reversed());
            Float avar= reports.get(0).getAvgChangeRate();
            if(avar>0){
                model.setCelue1("建议买入");
            }else{
                model.setCelue1("建议卖出");
            }
        });
        return getDataTable(list);
    }

    /**
     * 导出股票信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stockdec:export')")
    @Log(title = "股票信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockDec stockDec)
    {
        List<StockDec> list = stockDecService.selectStockDecList(stockDec);
        ExcelUtil<StockDec> util = new ExcelUtil<StockDec>(StockDec.class);
        util.exportExcel(response, list, "股票信息数据");
    }

    /**
     * 获取股票信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockdec:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stockDecService.selectStockDecById(id));
    }

    /**
     * 新增股票信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockdec:add')")
    @Log(title = "股票信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockDec stockDec)
    {
        return toAjax(stockDecService.insertStockDec(stockDec));
    }

    /**
     * 修改股票信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockdec:edit')")
    @Log(title = "股票信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockDec stockDec)
    {
        return toAjax(stockDecService.updateStockDec(stockDec));
    }

    /**
     * 删除股票信息
     */
    @PreAuthorize("@ss.hasPermi('business:stockdec:remove')")
    @Log(title = "股票信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stockDecService.deleteStockDecByIds(ids));
    }
}
