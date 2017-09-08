package com.github.seedm.repository.vo.seed;

import com.github.seedm.entities.enumeration.StatusEnum;

import java.util.Date;

/**
 * 学期表映射VO
 * @author Eugene
 */
public class SemesterVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 学期名称
     */
    private String name;

    /**
     * 所属学校ID
     */
    private String schoolId;

    /**
     * 学期状态
     */
    private StatusEnum status;

    /**
     * 开学时间
     */
    private Date beginTime;

    /**
     * 放假时间
     */
    private Date endTime;

    /**
     * 所属学校
     */
    private SchoolVo school;

    public SemesterVo() {
    }

    public SemesterVo(String id, String name, String schoolId, Date beginTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.schoolId = schoolId;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public SchoolVo getSchool() {
        return school;
    }

    public void setSchool(SchoolVo school) {
        this.school = school;
    }
}
