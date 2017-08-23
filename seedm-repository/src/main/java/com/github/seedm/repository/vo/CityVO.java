package com.github.seedm.repository.vo;

/**
 * 市级表映射VO
 * @author Eugene
 */
public class CityVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 市级编码
     */
    private String code;

    /**
     * 市级名称
     */
    private String name;

    /**
     * 所属省份
     */
    private ProvincesVO provincesVO;

    public CityVO() {
    }

    public CityVO(Long id, String code, String name, ProvincesVO provincesVO) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provincesVO = provincesVO;
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

    public ProvincesVO getProvincesVO() {
        return provincesVO;
    }

    public void setProvincesVO(ProvincesVO provincesVO) {
        this.provincesVO = provincesVO;
    }
}
