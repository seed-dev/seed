package com.github.seedm.entities.enumeration;

/**
 * 状态枚举
 * @author Eugene
 */
public enum StatusEnum {
    DISABLED(-1), ACTIVATE(1), LOCKED(2);

    private int status;

    StatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
