package com.github.seedm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.seedm.repository.entities.param.seed.AccountParam;
import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.entities.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    @Override
    public AccountVo queryOneByMobile(String mobile) {
        return this.accountMapper.selectOneByMobile(mobile);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountVo> queryAll() {
        PageHelper.startPage(1, 5);
        return this.accountMapper.selectAll();
    }

    @Override
    public int save(AccountParam account) {
        AccountVo acountVo = this.accountMapper.selectById(account.getId());
        if (acountVo != null) {
            throw new RuntimeException("用户已存在");
        }
        return this.accountMapper.insert(account);
    }

    @Override
    public int deleteById(String id) {
        AccountVo acountVo = this.accountMapper.selectById(id);
        if (acountVo == null) {
            throw new RuntimeException("用户不存在");
        }
        return this.accountMapper.deleteById(id);
    }

    @Override
    public int modify(AccountVo accountVo) {
        return this.accountMapper.update(accountVo);
    }
}
