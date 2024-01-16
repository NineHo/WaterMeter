package com.watermeter.system.controller;

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
import com.watermeter.common.annotation.Log;
import com.watermeter.common.enums.BusinessType;
import com.watermeter.system.domain.SysMeterInfo;
import com.watermeter.system.service.ISysMeterInfoService;
import com.watermeter.common.core.controller.BaseController;
import com.watermeter.common.core.domain.AjaxResult;
import com.watermeter.common.utils.poi.ExcelUtil;
import com.watermeter.common.core.page.TableDataInfo;

/**
 * 水表信息管理Controller
 * 
 * @author Patrick
 * @date 2023-05-24
 */
@Controller
@RequestMapping("/system/meterInfo")
public class SysMeterInfoController extends BaseController
{
    private String prefix = "system/meterInfo";

    @Autowired
    private ISysMeterInfoService sysMeterInfoService;

    @RequiresPermissions("system:meterInfo:view")
    @GetMapping()
    public String meterInfo()
    {
        return prefix + "/meterInfo";
    }

    /**
     * 查询水表信息管理列表
     */
    @RequiresPermissions("system:meterInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMeterInfo sysMeterInfo)
    {
        startPage();
        List<SysMeterInfo> list = sysMeterInfoService.selectSysMeterInfoList(sysMeterInfo);
        return getDataTable(list);
    }

    /**
     * 导出水表信息管理列表
     */
    @RequiresPermissions("system:meterInfo:export")
    @Log(title = "水表信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMeterInfo sysMeterInfo)
    {
        List<SysMeterInfo> list = sysMeterInfoService.selectSysMeterInfoList(sysMeterInfo);
        ExcelUtil<SysMeterInfo> util = new ExcelUtil<SysMeterInfo>(SysMeterInfo.class);
        return util.exportExcel(list, "水表信息管理数据");
    }

    /**
     * 新增水表信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存水表信息管理
     */
    @RequiresPermissions("system:meterInfo:add")
    @Log(title = "水表信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMeterInfo sysMeterInfo)
    {
        return toAjax(sysMeterInfoService.insertSysMeterInfo(sysMeterInfo));
    }

    /**
     * 修改水表信息管理
     */
    @RequiresPermissions("system:meterInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysMeterInfo sysMeterInfo = sysMeterInfoService.selectSysMeterInfoById(id);
        mmap.put("sysMeterInfo", sysMeterInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存水表信息管理
     */
    @RequiresPermissions("system:meterInfo:edit")
    @Log(title = "水表信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMeterInfo sysMeterInfo)
    {
        return toAjax(sysMeterInfoService.updateSysMeterInfo(sysMeterInfo));
    }

    /**
     * 删除水表信息管理
     */
    @RequiresPermissions("system:meterInfo:remove")
    @Log(title = "水表信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysMeterInfoService.deleteSysMeterInfoByIds(ids));
    }
}
