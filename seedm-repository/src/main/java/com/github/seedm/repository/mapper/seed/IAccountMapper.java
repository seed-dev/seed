package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.AccountVO;

import java.util.List;

/**
 * 账号表操作映射定义
 */
public interface IAccountMapper {

    /**
     * 新增账号
     * @param accountVO 账号表值实体
     */
    public void insert(AccountVO accountVO);

    public void deleteById(String id);

    public void update(AccountVO accountVO);

    public List<AccountVO> selectAll();

    public AccountVO selectActive(AccountVO accountVO);
}
