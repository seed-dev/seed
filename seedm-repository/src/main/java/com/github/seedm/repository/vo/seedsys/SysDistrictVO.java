package com.github.seedm.repository.vo.seedsys;

/**
 * 行政区表映射VO
 * @author Eugene
 */
public class SysDistrictVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 行政区编码
     */
    private String code;

    /**
     * 行政区名称
     */
    private String name;

    /**
     * 所属市
     */
    private SysCityVO cityVO;

    public SysDistrictVO() {
    }

    public SysDistrictVO(Long id, String code, String name, SysCityVO cityVO) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cityVO = cityVO;
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

    public SysCityVO getCityVO() {
        return cityVO;
    }

    public void setCityVO(SysCityVO cityVO) {
        this.cityVO = cityVO;
    }
}
