package com.ruoyi.department.controller;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.department.domain.Department;
import com.ruoyi.department.service.IDepartmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存储学院信息Controller
 * 
 * @author liao
 * @date 2024-01-16
 */
@Controller
@RequestMapping("/department/manage")
public class DepartmentController extends BaseController
{
    private String prefix = "department/manage";

    @Autowired
    private IDepartmentService departmentService;

    @RequiresPermissions("department:manage:view")
    @GetMapping()
    public String manage()
    {
        return prefix + "/manage";
    }

    /**
     * 查询存储学院信息列表
     */
    @RequiresPermissions("department:manage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Department department)
    {
        startPage();
        List<Department> list = departmentService.selectDepartmentList(department);
        return getDataTable(list);
    }

    /**
     * 导出存储学院信息列表
     */
    @RequiresPermissions("department:manage:export")
    @Log(title = "存储学院信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Department department)
    {
        List<Department> list = departmentService.selectDepartmentList(department);
        ExcelUtil<Department> util = new ExcelUtil<Department>(Department.class);
        return util.exportExcel(list, "存储学院信息数据");
    }

    /**
     * 新增存储学院信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存存储学院信息
     */
    @RequiresPermissions("department:manage:add")
    @Log(title = "存储学院信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Department department)
    {
        return toAjax(departmentService.insertDepartment(department));
    }

    /**
     * 修改存储学院信息
     */
    @RequiresPermissions("department:manage:edit")
    @GetMapping("/edit/{departmentId}")
    public String edit(@PathVariable("departmentId") Long departmentId, ModelMap mmap)
    {
        Department department = departmentService.selectDepartmentByDepartmentId(departmentId);
        mmap.put("department", department);
        return prefix + "/edit";
    }

    /**
     * 修改保存存储学院信息
     */
    @RequiresPermissions("department:manage:edit")
    @Log(title = "存储学院信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Department department)
    {
        return toAjax(departmentService.updateDepartment(department));
    }

    /**
     * 删除存储学院信息
     */
    @RequiresPermissions("department:manage:remove")
    @Log(title = "存储学院信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(departmentService.deleteDepartmentByDepartmentIds(ids));
    }
}
