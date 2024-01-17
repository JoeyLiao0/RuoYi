package com.ruoyi.department.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.department.domain.Lesson;
import com.ruoyi.department.mapper.DepartmentMapper;
import com.ruoyi.department.domain.Department;
import com.ruoyi.department.service.IDepartmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 存储学院信息Service业务层处理
 * 
 * @author liao
 * @date 2024-01-16
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService 
{
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询存储学院信息
     * 
     * @param departmentId 存储学院信息主键
     * @return 存储学院信息
     */
    @Override
    public Department selectDepartmentByDepartmentId(Long departmentId)
    {
        return departmentMapper.selectDepartmentByDepartmentId(departmentId);
    }

    /**
     * 查询存储学院信息列表
     * 
     * @param department 存储学院信息
     * @return 存储学院信息
     */
    @Override
    public List<Department> selectDepartmentList(Department department)
    {
        return departmentMapper.selectDepartmentList(department);
    }

    /**
     * 新增存储学院信息
     * 
     * @param department 存储学院信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDepartment(Department department)
    {
        int rows = departmentMapper.insertDepartment(department);
        insertLesson(department);
        return rows;
    }

    /**
     * 修改存储学院信息
     * 
     * @param department 存储学院信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDepartment(Department department)
    {
        departmentMapper.deleteLessonByDepartmentId(department.getDepartmentId());
        insertLesson(department);
        return departmentMapper.updateDepartment(department);
    }

    /**
     * 批量删除存储学院信息
     * 
     * @param departmentIds 需要删除的存储学院信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDepartmentByDepartmentIds(String departmentIds)
    {
        departmentMapper.deleteLessonByDepartmentIds(Convert.toStrArray(departmentIds));
        return departmentMapper.deleteDepartmentByDepartmentIds(Convert.toStrArray(departmentIds));
    }

    /**
     * 删除存储学院信息信息
     * 
     * @param departmentId 存储学院信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDepartmentByDepartmentId(Long departmentId)
    {
        departmentMapper.deleteLessonByDepartmentId(departmentId);
        return departmentMapper.deleteDepartmentByDepartmentId(departmentId);
    }

    /**
     * 新增课程管理信息
     * 
     * @param department 存储学院信息对象
     */
    public void insertLesson(Department department)
    {
        List<Lesson> lessonList = department.getLessonList();
        Long departmentId = department.getDepartmentId();
        if (StringUtils.isNotNull(lessonList))
        {
            List<Lesson> list = new ArrayList<Lesson>();
            for (Lesson lesson : lessonList)
            {
                lesson.setDepartmentId(departmentId);
                list.add(lesson);
            }
            if (list.size() > 0)
            {
                departmentMapper.batchLesson(list);
            }
        }
    }
}
