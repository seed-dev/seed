package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.seed.PermissionVo;

import java.util.List;

/**
 * 权限表映射操作定义
 * @author Eugene
 */
public interface IPermissionMapper {

    /**
     * 新增权限信息
     * @param permissionVo 权限信息
     * @return 成功新增的权限信息条数
     */
    public int insert(PermissionVo permissionVo);

    /**
     * 批量新增权限信息
     * @param permissions 权限信息集合
     * @return 成功新增的权限信息条数
     */
    public int insertMulti(List<PermissionVo> permissions);

    /**
     * 更具ID删除权限信息
     * @param id 权限信息ID
     * @return 成功删除权限信息条数
     */
    public int deleteById(String id);

    /**
     * 更新权限信息
     * @param permissionVo 权限信息
     * @return 成功更新权限信息的条数
     */
    public int update(PermissionVo permissionVo);

    /**
     * 根据ID查询权限信息
     * @param id 权限信息ID
     * @return 权限信息
     */
    public PermissionVo selectById(String id);

    /**
     * 查询全部权限信息
     * @return 系统全部权限信息列表
     */
    public List<PermissionVo> selectAll();

    /**
     * 查询权限信息，使用复合条件过滤
     * @param permissionVo 权限信息
     * @return 权限信息列表
     */
    public List<PermissionVo> selectAllByCriteria(PermissionVo permissionVo);
}
