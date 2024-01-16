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
import com.watermeter.system.domain.SysAreaConnector;
import com.watermeter.system.service.ISysAreaConnectorService;
import com.watermeter.common.core.controller.BaseController;
import com.watermeter.common.core.domain.AjaxResult;
import com.watermeter.common.utils.poi.ExcelUtil;
import com.watermeter.common.core.page.TableDataInfo;

/**
 * 告警联系人Controller
 * 
 * @author patrick
 * @date 2023-04-18
 */
@Controller
@RequestMapping("/system/connector")
public class SysAreaConnectorController extends BaseController
{
    private String prefix = "system/connector";

    @Autowired
    private ISysAreaConnectorService sysAreaConnectorService;

    @RequiresPermissions("system:connector:view")
    @GetMapping()
    public String connector()
    {
        return prefix + "/connector";
    }

    /**
     * 查询告警联系人列表
     */
    @RequiresPermissions("system:connector:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAreaConnector sysAreaConnector)
    {
        startPage();
        List<SysAreaConnector> list = sysAreaConnectorService.selectSysAreaConnectorList(sysAreaConnector);
        return getDataTable(list);
    }

    /**
     * 导出告警联系人列表
     */
    @RequiresPermissions("system:connector:export")
    @Log(title = "告警联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysAreaConnector sysAreaConnector)
    {
        List<SysAreaConnector> list = sysAreaConnectorService.selectSysAreaConnectorList(sysAreaConnector);
        ExcelUtil<SysAreaConnector> util = new ExcelUtil<SysAreaConnector>(SysAreaConnector.class);
        return util.exportExcel(list, "告警联系人数据");
    }

    /**
     * 新增告警联系人
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存告警联系人
     */
    @RequiresPermissions("system:connector:add")
    @Log(title = "告警联系人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysAreaConnector sysAreaConnector)
    {
        return toAjax(sysAreaConnectorService.insertSysAreaConnector(sysAreaConnector));
    }

    /**
     * 修改告警联系人
     */
    @RequiresPermissions("system:connector:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysAreaConnector sysAreaConnector = sysAreaConnectorService.selectSysAreaConnectorById(id);
        mmap.put("sysAreaConnector", sysAreaConnector);
        return prefix + "/edit";
    }

    /**
     * 修改保存告警联系人
     */
    @RequiresPermissions("system:connector:edit")
    @Log(title = "告警联系人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysAreaConnector sysAreaConnector)
    {
        return toAjax(sysAreaConnectorService.updateSysAreaConnector(sysAreaConnector));
    }

    /**
     * 删除告警联系人
     */
    @RequiresPermissions("system:connector:remove")
    @Log(title = "告警联系人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysAreaConnectorService.deleteSysAreaConnectorByIds(ids));
    }
}
