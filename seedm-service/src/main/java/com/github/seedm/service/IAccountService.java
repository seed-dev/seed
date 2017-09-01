package com.github.seedm.service;

import com.github.seedm.repository.vo.seed.AccountVo;

/**
 * 账号信息业务处理接口定义
 * @author Eugene
 */
public interface IAccountService {

    /**
     * 查询系统可用账号信息，可制定单条件或复合条件
     * @param accountVo 查询条件
     * @return 账号信息
     */
    public AccountVo queryActive(AccountVo accountVo);
}
