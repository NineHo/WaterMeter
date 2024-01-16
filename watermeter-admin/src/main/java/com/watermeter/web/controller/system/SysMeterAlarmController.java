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
import com.watermeter.system.domain.SysMeterAlarm;
import com.watermeter.system.service.ISysMeterAlarmService;
import com.watermeter.common.core.controller.BaseController;
import com.watermeter.common.core.domain.AjaxResult;
import com.watermeter.common.utils.poi.ExcelUtil;
import com.watermeter.common.core.page.TableDataInfo;

/**
 * 告警记录Controller
 * 
 * @author Patrick
 * @date 2023-04-18
 */
@Controller
@RequestMapping("/system/alarm")
public class SysMeterAlarmController extends BaseController
{
    private String prefix = "system/alarm";

    @Autowired
    private ISysMeterAlarmService sysMeterAlarmService;

    @RequiresPermissions("system:alarm:view")
    @GetMapping()
    public String alarm()
    {
        return prefix + "/alarm";
    }

    /**
     * 查询告警记录列表
     */
    @RequiresPermissions("system:alarm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMeterAlarm sysMeterAlarm)
    {
        startPage();
        List<SysMeterAlarm> list = sysMeterAlarmService.selectSysMeterAlarmList(sysMeterAlarm);
        return getDataTable(list);
    }

    /**
     * 导出告警记录列表
     */
    @RequiresPermissions("system:alarm:export")
    @Log(title = "告警记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMeterAlarm sysMeterAlarm)
    {
        List<SysMeterAlarm> list = sysMeterAlarmService.selectSysMeterAlarmList(sysMeterAlarm);
        ExcelUtil<SysMeterAlarm> util = new ExcelUtil<SysMeterAlarm>(SysMeterAlarm.class);
        return util.exportExcel(list, "告警记录数据");
    }

    /**
     * 新增告警记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存告警记录
     */
    @RequiresPermissions("system:alarm:add")
    @Log(title = "告警记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMeterAlarm sysMeterAlarm)
    {
        return toAjax(sysMeterAlarmService.insertSysMeterAlarm(sysMeterAlarm));
    }

    /**
     * 修改告警记录
     */
    @RequiresPermissions("system:alarm:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysMeterAlarm sysMeterAlarm = sysMeterAlarmService.selectSysMeterAlarmById(id);
        mmap.put("sysMeterAlarm", sysMeterAlarm);
        return prefix + "/edit";
    }

    /**
     * 修改保存告警记录
     */
    @RequiresPermissions("system:alarm:edit")
    @Log(title = "告警记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMeterAlarm sysMeterAlarm)
    {
        return toAjax(sysMeterAlarmService.updateSysMeterAlarm(sysMeterAlarm));
    }

    /**
     * 删除告警记录
     */
    @RequiresPermissions("system:alarm:remove")
    @Log(title = "告警记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysMeterAlarmService.deleteSysMeterAlarmByIds(ids));
    }
}
