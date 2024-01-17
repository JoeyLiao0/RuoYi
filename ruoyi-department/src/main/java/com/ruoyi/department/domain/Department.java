package com.ruoyi.department.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 存储学院信息对象 department
 * 
 * @author liao
 * @date 2024-01-16
 */
public class Department extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学院编号 */
    private Long departmentId;

    /** 学院名称 */
    @Excel(name = "学院名称")
    private String departmentName;

    /** 学院类型 */
    @Excel(name = "学院类型")
    private String departmentType;

    /** 学生人数 */
    @Excel(name = "学生人数")
    private Long departmentNum;

    /** 课程管理信息 */
    private List<Lesson> lessonList;

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
    }
    public void setDepartmentType(String departmentType) 
    {
        this.departmentType = departmentType;
    }

    public String getDepartmentType() 
    {
        return departmentType;
    }
    public void setDepartmentNum(Long departmentNum) 
    {
        this.departmentNum = departmentNum;
    }

    public Long getDepartmentNum() 
    {
        return departmentNum;
    }

    public List<Lesson> getLessonList()
    {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList)
    {
        this.lessonList = lessonList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("departmentId", getDepartmentId())
            .append("departmentName", getDepartmentName())
            .append("departmentType", getDepartmentType())
            .append("departmentNum", getDepartmentNum())
            .append("lessonList", getLessonList())
            .toString();
    }
}
