package com.ruoyi.department.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程管理对象 lesson
 * 
 * @author liao
 * @date 2024-01-16
 */
public class Lesson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程编号 */
    private Long lessonId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String lessonName;

    /** 课程类型 */
    @Excel(name = "课程类型")
    private String lessonType;

    /** 课程学生人数 */
    @Excel(name = "课程学生人数")
    private Long lessonNum;

    /** 课程所属院系 */
    @Excel(name = "课程所属院系")
    private Long departmentId;

    public void setLessonId(Long lessonId) 
    {
        this.lessonId = lessonId;
    }

    public Long getLessonId() 
    {
        return lessonId;
    }
    public void setLessonName(String lessonName) 
    {
        this.lessonName = lessonName;
    }

    public String getLessonName() 
    {
        return lessonName;
    }
    public void setLessonType(String lessonType) 
    {
        this.lessonType = lessonType;
    }

    public String getLessonType() 
    {
        return lessonType;
    }
    public void setLessonNum(Long lessonNum) 
    {
        this.lessonNum = lessonNum;
    }

    public Long getLessonNum() 
    {
        return lessonNum;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lessonId", getLessonId())
            .append("lessonName", getLessonName())
            .append("lessonType", getLessonType())
            .append("lessonNum", getLessonNum())
            .append("departmentId", getDepartmentId())
            .toString();
    }
}
