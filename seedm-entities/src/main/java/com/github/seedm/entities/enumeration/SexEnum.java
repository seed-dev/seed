package com.github.seedm.entities.enumeration;

/**
 * 性别枚举
 * @author Eugene
 */
public enum SexEnum {

    MALE("男", "m"), FEMALE("女", "f");
    private String name;

    private String sign;

    SexEnum(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }


}
