package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.seed.AccountVO;

import java.util.List;

/**
 * 账号表操作映射定义
 * @author Eugene
 */
public interface IAccountMapper {

    /**
     * 新增账号
     * @param accountVO 账号信息
     * @return 成功新增账号信息条数
     */
    public int insert(AccountVO accountVO);

    /**
     * 删除指定ID的账号
     * @param id 账号ID
     * @return 成功删除账号信息条数
     */
    public int deleteById(String id);

    /**
     * 更新账号信息
     * @param accountVO 账号信息
     * @return 成功更新账号信息条数
     */
    public int update(AccountVO accountVO);

    /**
     * 查询全部账号
     * @return 系统全部账号列表
     */
    public List<AccountVO> selectAll();

    /**
     * 查询一个指定用户ID或手机号码的账号信息
     * @param accountVO 账号信息
     * @return 账号信息
     */
    public AccountVO selectActive(AccountVO accountVO);
}
