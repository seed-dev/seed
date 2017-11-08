package com.github.seedm.repository.mapper;

import com.github.seedm.repository.entities.vo.SchoolRoleVo;

/**
 * 学校角色关系表映射操作
 */
public interface ISchoolRoleMapper {

    /**
     * 新增学校角色关系绑定
     * @param schoolRoleVo 学校角色关系绑定信息
     * @return 成功绑定数据条数
     */
    public int insert(SchoolRoleVo schoolRoleVo);
}
