package com.github.seedm.repository.vo.seed;

import com.github.seedm.entities.enumeration.StatusEnum;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 账号表映射VO
 * @author Eugene
 */
public class AccountVo {

    private String id;

    private String name;

    private String password;

    private Date birthday;

    private String idcardNo;

    private String userId;

    private String nickname;

    private String mobile;

    private StatusEnum status;

    private Timestamp createTime;

    private List<SchoolVo> schools;

    public AccountVo() {
    }

    public AccountVo(String password, String mobile) {
        this.password = password;
        this.mobile = mobile;
    }

    public AccountVo(String password, String mobile, StatusEnum status) {
        this.password = password;
        this.mobile = mobile;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
