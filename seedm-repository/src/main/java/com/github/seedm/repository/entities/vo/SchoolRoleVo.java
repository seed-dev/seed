package com.github.seedm.repository.entities.vo;

/**
 * 学校角色关系表映射VO
 */
public class SchoolRoleVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 学校
     */
    private String schoolId;

    /**
     * 角色
     */
    private String roleId;

    public SchoolRoleVo() {
    }

    public SchoolRoleVo(String id, String schoolId, String roleId) {
        this.id = id;
        this.schoolId = schoolId;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
