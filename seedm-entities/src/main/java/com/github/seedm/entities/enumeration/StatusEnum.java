package com.github.seedm.entities.enumeration;

/**
 * 状态枚举
 * @author Eugene
 */
public enum StatusEnum {
    DISABLED("不可用", -1), ACTIVATE("可用", 1), LOCKED("冻结", 2);

    private String name;
    private int status;

    StatusEnum(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public static StatusEnum getStatusEnum(int status) {
        StatusEnum [] statusEnums = StatusEnum.values();
        for (StatusEnum statusEnum : statusEnums) {
            if (statusEnum.getStatus() == status) {
                return statusEnum;
            }
        }
        return null;
    }
}
