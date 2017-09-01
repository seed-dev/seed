package com.github.seedm.entities.enumeration;

/**
 * 角色枚举，角色包含监护人、老师、辅导员、校长
 * @author Eugene
 */
public enum RoleEnum {

    GUARDIAN("guardian"), TEACHER("teacher"), INSTRUCTOR("instructor"), PRINCIPAL("principal");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
