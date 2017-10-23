package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.entities.vo.seed.RoleVo;

import java.util.List;

/**
 * 角色表映射操作定义
 * @author Eugene
 */
public interface IRoleMapper {

    /**
     * 新增角色
     * @param roleVo 角色信息
     * @return 成功新增的数据条数
     */
    public int insert(RoleVo roleVo);

    /**
     * 批量新增角色
     * @param roles 角色信息集合
     * @return 成功新增的数据条数
     */
    public int insertMulti(List<RoleVo> roles);

    /**
     * 根据ID查询角色信息
     * @param id 角色信息ID
     * @return 角色信息
     */
    public RoleVo selectById(String id);

    /**
     * 根据ID查询角色信息，包括角色所拥有的权限信息
     * @param id 角色信息ID
     * @return 角色信息列表
     */
    public List<RoleVo> selectWithPermissionById(String id);
}
