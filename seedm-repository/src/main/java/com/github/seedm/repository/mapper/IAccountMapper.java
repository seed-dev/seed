package com.github.seedm.repository.mapper;

import com.github.seedm.repository.entities.param.AccountParam;
import com.github.seedm.repository.entities.vo.AccountVo;

import java.util.List;

/**
 * 账号表操作映射定义
 * @author Eugene
 */
public interface IAccountMapper {

    /**
     * 新增账号
     * @param account 账号信息
     * @return 成功新增账号信息条数
     */
    public int insert(AccountParam account);

    /**
     * 批量新增账号
     * @param accounts 账号信息集合
     * @return 成功新增账号信息条数
     */
    public int insertMulti(List<AccountParam> accounts);

    /**
     * 删除指定ID的账号
     * @param id 账号ID
     * @return 成功删除账号信息条数
     */
    public int deleteById(String id);

    /**
     * 更新账号信息
     * @param account 账号信息
     * @return 成功更新账号信息条数
     */
    public int update(AccountVo account);

    /**
     * 查询指定ID的账号
     * @param id 账号ID
     * @return 账号信息
     */
    public AccountVo selectById(String id);

    /**
     * 查询全部账号
     * @return 系统全部账号列表
     */
    public List<AccountVo> selectAll();

    /**
     * 根据手机查询唯一的账号信息
     * @param mobile 手机
     * @return 账号信息
     */
    public AccountVo selectOneByMobile(String mobile);

    /**
     * 查询账号信息，使用复合条件过滤
     * @param account 账号信息
     * @return 账号信息列表
     */
    public List<AccountVo> selectAllByCriteria(AccountParam account);
}
