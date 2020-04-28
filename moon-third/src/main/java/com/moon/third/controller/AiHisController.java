package com.moon.third.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.moon.common.annotation.Log;
import com.moon.common.enums.BusinessType;
import com.moon.third.domain.AiHis;
import com.moon.third.service.IAiHisService;
import com.moon.common.core.controller.BaseController;
import com.moon.common.core.domain.AjaxResult;
import com.moon.common.utils.poi.ExcelUtil;
import com.moon.common.core.page.TableDataInfo;

/**
 * 人工智能图片识别历史Controller
 * 
 * @author wujiyue
 * @date 2019-10-12
 */
@Controller
@RequestMapping("/third/aiHis")
public class AiHisController extends BaseController
{
    private String prefix = "third/aiHis";

    @Autowired
    private IAiHisService aiHisService;

    @RequiresPermissions("third:aiHis:view")
    @GetMapping()
    public String aiHis()
    {
        return prefix + "/aiHis";
    }

    /**
     * 查询人工智能图片识别历史列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiHis aiHis)
    {
        startPage();
        List<AiHis> list = aiHisService.selectAiHisList(aiHis);
        return getDataTable(list);
    }

    /**
     * 导出人工智能图片识别历史列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiHis aiHis)
    {
        List<AiHis> list = aiHisService.selectAiHisList(aiHis);
        ExcelUtil<AiHis> util = new ExcelUtil<AiHis>(AiHis.class);
        return util.exportExcel(list, "aiHis");
    }

    /**
     * 识别历史详情
     */
    @GetMapping("/detail/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AiHis aiHis = aiHisService.selectAiHisById(id);
        mmap.put("aiHis", aiHis);
        return prefix + "/detail";
    }

    /**
     * 删除人工智能图片识别历史
     */
    @Log(title = "人工智能图片识别历史", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiHisService.deleteAiHisByIds(ids));
    }
}
