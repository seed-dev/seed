package com.github.seedm.repository.entities.vo;

/**
 * 省份表映射VO
 * @author Eugene
 */
public class SysProvincesVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 省份编码
     */
    private String code;

    /**
     * 省份
     */
    private String name;

    public SysProvincesVO() {
    }

    public SysProvincesVO(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
