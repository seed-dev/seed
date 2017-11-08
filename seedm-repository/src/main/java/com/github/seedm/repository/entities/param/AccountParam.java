package com.github.seedm.repository.entities.param;

import com.github.seedm.entities.enumeration.SexEnum;
import com.github.seedm.entities.enumeration.StatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * 账号信息
 * @author Eugene
 */
public class AccountParam implements Serializable {

    private static final long serialVersionUID = -6697496774857187308L;
    private String id;

    private String name;

    private String password;

    private Date birthday;

    private SexEnum sex;

    private String idcardNo;

    private String userId;

    private String nickname;

    private String mobile;

    private StatusEnum status;

    private Date createTime;

    public AccountParam() {
    }

    public AccountParam(String password, String mobile) {
        this.password = password;
        this.mobile = mobile;
    }

    public AccountParam(String id, String name, String password, Date birthday, SexEnum sex, String idcardNo, String userId, String nickname, String mobile) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.idcardNo = idcardNo;
        this.userId = userId;
        this.nickname = nickname;
        this.mobile = mobile;
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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
