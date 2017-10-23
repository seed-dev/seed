package com.github.seedm.repository.mapper.seedsys;

import com.github.seedm.repository.entities.vo.seedsys.SysDistrictVO;

import java.util.List;

/**
 * 系统数据库区县信息表映射定义
 * @author Eugene
 */
public interface ISysDistrictMapper {

    /**
     * 根据市级编码查询区县信息
     * @param cityCode 市级编码
     * @return 区县信息列表
     */
    public List<SysDistrictVO> selectByCityCode(String cityCode);
}
