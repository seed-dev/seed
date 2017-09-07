package com.github.seedm.repository.vo.seed;

import java.util.Set;

/**
 * 行政区表映射VO
 * @author Eugene
 */
public class SchoolVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 学校名称
     */
    private String name;

    /**
     * 学校简介
     */
    private String intro;

    /**
     * 学校地址
     */
    private String address;

    /**
     * 学校联系方式
     */
    private String contactNo;

    /**
     * 学校信息创建时间
     */
    private String createTime;

    /**
     * 学期列表
     */
    private Set<SemesterVo> semesters;

    public SchoolVo() {
    }

    public SchoolVo(String id, String name, String intro, String address, String contactNo) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.address = address;
        this.contactNo = contactNo;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Set<SemesterVo> getSemesters() {
        return semesters;
    }

    public void setSemesters(Set<SemesterVo> semesters) {
        this.semesters = semesters;
    }
}
