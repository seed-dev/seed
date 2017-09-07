package com.github.seedm.repository.mapper.seedsys;

import com.github.seedm.repository.vo.seedsys.SysCityVO;

import java.util.List;

/**
 * 系统数据库城市表映射定义
 * @author Eugene
 */
public interface ISysCityMapper {

    /**
     * 根据省份编码查询系统数据库全部城市信息
     * @param provinceCode 省份编码
     * @return 城市信息列表
     */
    public List<SysCityVO> selectByProvince(String provinceCode);
}
