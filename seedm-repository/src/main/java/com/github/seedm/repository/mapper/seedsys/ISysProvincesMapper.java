package com.github.seedm.repository.mapper.seedsys;

import com.github.seedm.repository.vo.seedsys.SysProvincesVO;

import java.util.List;

/**
 * 系统数据库省份表映射定义
 * @author Eugene
 */
public interface ISysProvincesMapper {

    /**
     * 查询系统数据库全部省份信息
     * @return 省份信息列表
     */
    public List<SysProvincesVO> selectAll();
}
