package com.watermeter.web.controller.system;

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
import com.watermeter.system.domain.User;
import com.watermeter.system.service.IUserService;
import com.watermeter.common.core.controller.BaseController;
import com.watermeter.common.core.domain.AjaxResult;
import com.watermeter.common.utils.poi.ExcelUtil;
import com.watermeter.common.core.page.TableDataInfo;

/**
 * 用户信息管理Controller
 * 
 * @author Patrick
 * @date 2023-04-05
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController
{
    private String prefix = "admin/user";

    @Autowired
    private IUserService userService;

    @RequiresPermissions("admin:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户信息管理列表
     */
    @RequiresPermissions("admin:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出用户信息管理列表
     */
    @RequiresPermissions("admin:user:export")
    @Log(title = "用户信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        return util.exportExcel(list, "用户信息管理数据");
    }

    /**
     * 新增用户信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息管理
     */
    @RequiresPermissions("admin:user:add")
    @Log(title = "用户信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(User user)
    {
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户信息管理
     */
    @RequiresPermissions("admin:user:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        User user = userService.selectUserById(id);
        mmap.put("user", user);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息管理
     */
    @RequiresPermissions("admin:user:edit")
    @Log(title = "用户信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(User user)
    {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户信息管理
     */
    @RequiresPermissions("admin:user:remove")
    @Log(title = "用户信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userService.deleteUserByIds(ids));
    }
}
