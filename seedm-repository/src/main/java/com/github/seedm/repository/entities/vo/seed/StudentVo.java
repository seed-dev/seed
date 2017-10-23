package com.github.seedm.repository.entities.vo.seed;

import com.github.seedm.entities.enumeration.SexEnum;
import com.github.seedm.entities.enumeration.StatusEnum;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 学生信息表映射VO
 * @author Eugene
 */
public class StudentVo {

    private String id;

    private String name;

    private SexEnum sex;

    private Date birthday;

    private String idcardNo;

    private StatusEnum status;

    private Timestamp createTime;

    private List<SchoolVo> schools;

    public StudentVo() {
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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<SchoolVo> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolVo> schools) {
        this.schools = schools;
    }
}
