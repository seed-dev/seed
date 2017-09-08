package com.github.seedm.repository.vo.seed;

/**
 * 角色权限关系表映射VO
 */
public class RolePermissionVo {

    /**
     * 主键
     */
    private String id;
    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 显现ID
     */
    private String permissionId;



    public RolePermissionVo() {
    }

    public RolePermissionVo(String id, String roleId, String permissionId) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
