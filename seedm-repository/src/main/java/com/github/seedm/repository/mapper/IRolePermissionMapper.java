package com.github.seedm.repository.mapper;

import com.github.seedm.repository.entities.vo.RolePermissionVo;

import java.util.List;

/**
 * 角色权限关系表映射操作
 */
public interface IRolePermissionMapper {

    /**
     * 新增角色权限关系绑定
     * @param rolePermissionVo 角色权限关系绑定信息
     * @return 成功绑定数据条数
     */
    public int insert(RolePermissionVo rolePermissionVo);

    /**
     * 批量新增角色权限关系绑定
     * @param rolePermissions 角色权限关系绑定信息集合
     * @return 成功新增角色权限关系绑定信息条数
     */
    public int insertMulti(List<RolePermissionVo> rolePermissions);
}
