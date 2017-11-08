package com.github.seedm.repository.entities.vo;

/**
 * 权限表映射VO
 * @author Eugene
 */
public class PermissionVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限标识
     */
    private String sign;

    /**
     * 权限描述信息
     */
    private String description;

    public PermissionVo() {
    }

    public PermissionVo(String id, String name, String sign, String description) {
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
