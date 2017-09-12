package com.github.seedm.repository.vo.seed;

import com.github.seedm.entities.enumeration.RoleEnum;

import java.util.List;

/**
 * 角色表映射VO
 * @author Eugene
 */
public class RoleVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色标识
     */
    private RoleEnum sign;

    /**
     * 角色描述信息
     */
    private String description;

    /**
     * 权限列表
     */
    private List<PermissionVo> permissions;

    public RoleVo() {
    }

    public RoleVo(String id, String name, RoleEnum sign, String description) {
        this.id = id;
        this.name = name;
        this.sign = sign;
        this.description = description;
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

    public RoleEnum getSign() {
        return sign;
    }

    public void setSign(RoleEnum sign) {
        this.sign = sign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PermissionVo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVo> permissions) {
        this.permissions = permissions;
    }
}
