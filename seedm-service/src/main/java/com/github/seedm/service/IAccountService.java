package com.github.seedm.service;

import com.github.seedm.repository.entities.param.AccountParam;
import com.github.seedm.repository.entities.vo.AccountVo;

import java.util.List;

/**
 * 账号信息业务处理接口定义
 * @author Eugene
 */
public interface IAccountService {

    public int save(AccountParam account);

    public int deleteById(String id);

    public int modify(AccountVo accountVo);

    /**
     * 根据ID查询账号信息
     * @param id 账号信息ID
     * @return 账号信息
     */
    public AccountVo queryById(String id);

    /**
     * 根据手机查询唯一的账号信息
     * @param mobile 手机
     * @return 账号信息
     */
    public AccountVo queryOneByMobile(String mobile);

    public List<AccountVo> queryAll();
}
