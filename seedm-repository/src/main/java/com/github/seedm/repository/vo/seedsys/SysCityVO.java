package com.github.seedm.repository.vo.seedsys;

/**
 * 市级表映射VO
 * @author Eugene
 */
public class SysCityVO {

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
    private SysProvincesVO provincesVO;

    public SysCityVO() {
    }

    public SysCityVO(Long id, String code, String name, SysProvincesVO provincesVO) {
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

    public SysProvincesVO getProvincesVO() {
        return provincesVO;
    }

    public void setProvincesVO(SysProvincesVO provincesVO) {
        this.provincesVO = provincesVO;
    }
}
