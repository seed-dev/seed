package com.github.seedm.service.impl;

import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账号信息业务处理实现类
 * @author Eugene
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountMapper accountMapper;

    @Override
    public AccountVo queryActive(AccountVo accountVo) {
        return this.accountMapper.selectActiveAccounts(accountVo);
    }
}
