package com.github.seedm.entities.result;

/**
 * 带标识符的结果实体
 * @author Eugene
 */
public class FlagResult {

    /**
     * 未知
     */
    public static final int UNKNOWN = -1;

    /**
     * 错误
     */
    public static final int ERROR = 0;

    /**
     * 成功
     */
    public static final int SUCCESS = 1;

    /**
     * 结果标识符
     */
    public int flag = FlagResult.SUCCESS;

    /**
     * 结果附加消息
     */
    public String msg;

    /**
     * 结果数据
     */
    public Object data;

    public FlagResult() {
    }

    public FlagResult(int flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public FlagResult(int flag, String msg, Object data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
