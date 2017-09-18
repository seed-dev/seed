package com.github.seedm.test.service;

import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testQueryById() {
        AccountVo accountVo = this.accountService.queryById("35bc83ab7923449e8612253e336ed801");
        System.out.println(accountVo.getName());
//        accountVo.setName("测试用户26A");
//        int count = this.accountService.modify(accountVo);
//
//        if (count > 0) {
            accountVo = this.accountService.queryById("35bc83ab7923449e8612253e336ed801");
            System.out.println(accountVo.getName());
//        }

    }

    @Test
    public void testSelectAll() {
        int count = this.accountService.queryAll().size();
        System.out.println(count);
    }
}
