package com.ruoyi.department.mapper;

import java.util.List;
import com.ruoyi.department.domain.Department;
import com.ruoyi.department.domain.Lesson;

/**
 * 存储学院信息Mapper接口
 * 
 * @author liao
 * @date 2024-01-16
 */
public interface DepartmentMapper 
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
     * 删除存储学院信息
     * 
     * @param departmentId 存储学院信息主键
     * @return 结果
     */
    public int deleteDepartmentByDepartmentId(Long departmentId);

    /**
     * 批量删除存储学院信息
     * 
     * @param departmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepartmentByDepartmentIds(String[] departmentIds);

    /**
     * 批量删除课程管理
     * 
     * @param departmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLessonByDepartmentIds(String[] departmentIds);
    
    /**
     * 批量新增课程管理
     * 
     * @param lessonList 课程管理列表
     * @return 结果
     */
    public int batchLesson(List<Lesson> lessonList);
    

    /**
     * 通过存储学院信息主键删除课程管理信息
     * 
     * @param departmentId 存储学院信息ID
     * @return 结果
     */
    public int deleteLessonByDepartmentId(Long departmentId);
}
