package com.github.seedm.service;

import com.github.seedm.repository.vo.seed.AccountVo;

import java.util.List;

/**
 * 账号信息业务处理接口定义
 * @author Eugene
 */
public interface IAccountService {

    /**
     * 根据ID查询账号信息
     * @param id 账号信息ID
     * @return 账号信息
     */
    public AccountVo queryById(String id);

    public List<AccountVo> queryAll();

    public int modify(AccountVo accountVo);
}
