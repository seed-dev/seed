package com.github.seedm.service.impl;

import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账号信息业务处理实现类
 * @author Eugene
 */
@Service
@Transactional
public class AccountService implements IAccountService {

    @Autowired
    private IAccountMapper accountMapper;

    @Transactional(readOnly = true)
    @Override
    public AccountVo queryById(String id) {
        return this.accountMapper.selectById(id);
    }

    @Override
    public int modify(AccountVo accountVo) {
        return this.accountMapper.update(accountVo);
    }
}
