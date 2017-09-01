package com.github.seedm.service.impl;

import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.seed.AccountVO;
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
    public AccountVO queryActive(AccountVO accountVO) {
        return this.accountMapper.selectActiveAccounts(accountVO);
    }
}
