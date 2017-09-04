package com.github.seedm.repository.vo.seed;

/**
 * 账号学校关系表映射VO
 */
public class AccountSchoolVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 账号ID
     */
    private String accountId;

    /**
     * 学校ID
     */
    private String schoolId;

    public AccountSchoolVo() {
    }

    public AccountSchoolVo(String id, String accountId, String schoolId) {
        this.id = id;
        this.accountId = accountId;
        this.schoolId = schoolId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
