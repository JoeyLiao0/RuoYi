package com.ruoyi.department.service;

import java.util.List;
import com.ruoyi.department.domain.Department;

/**
 * 存储学院信息Service接口
 * 
 * @author liao
 * @date 2024-01-16
 */
public interface IDepartmentService 
{
    /**
     * 查询存储学院信息
     * 
     * @param departmentId 存储学院信息主键
     * @return 存储学院信息
     */
    public Department selectDepartmentByDepartmentId(Long departmentId);

    /**
     * 查询存储学院信息列表
     * 
     * @param department 存储学院信息
     * @return 存储学院信息集合
     */
    public List<Department> selectDepartmentList(Department department);

    /**
     * 新增存储学院信息
     * 
     * @param department 存储学院信息
     * @return 结果
     */
    public int insertDepartment(Department department);

    /**
     * 修改存储学院信息
     * 
     * @param department 存储学院信息
     * @return 结果
     */
    public int updateDepartment(Department department);

    /**
     * 批量删除存储学院信息
     * 
     * @param departmentIds 需要删除的存储学院信息主键集合
     * @return 结果
     */
    public int deleteDepartmentByDepartmentIds(String departmentIds);

    /**
     * 删除存储学院信息信息
     * 
     * @param departmentId 存储学院信息主键
     * @return 结果
     */
    public int deleteDepartmentByDepartmentId(Long departmentId);
}
