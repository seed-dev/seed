package com.github.seedm.entities.enumeration;

/**
 * 角色枚举，角色包含监护人、老师、辅导员、校长
 * @author Eugene
 */
public enum RoleEnum {

    STUDENT("学生", "student"), GUARDIAN("监护人", "guardian"), TEACHER("老师", "teacher"), INSTRUCTOR("辅导员", "instructor"), PRINCIPAL("校长", "principal");

    private String name;

    private String sign;

    RoleEnum(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }


}
