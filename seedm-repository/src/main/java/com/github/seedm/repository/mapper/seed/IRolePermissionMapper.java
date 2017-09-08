package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.seed.RolePermissionVo;

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
}
