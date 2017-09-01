package com.github.seedm.repository.vo.seed;

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
    private String contactNumber;

    /**
     * 学校信息创建时间
     */
    private String createTime;

    public SchoolVo() {
    }

    public SchoolVo(String id, String name, String intro, String address, String contactNumber) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.address = address;
        this.contactNumber = contactNumber;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
