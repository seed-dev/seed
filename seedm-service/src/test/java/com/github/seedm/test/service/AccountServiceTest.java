package com.github.seedm.test.service;

import com.github.seedm.entities.enumeration.SexEnum;
import com.github.seedm.repository.entities.param.seed.AccountParam;
import com.github.seedm.repository.entities.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import com.github.toolkit.core.CodecKit;
import com.github.toolkit.core.StringKit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Test
    public void initTestAcount() throws ParseException {
        AccountParam account = new AccountParam();
        account.setId(stringKit.uuid(true));
        account.setName("陈志恒");
        account.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        account.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-03-23"));
        account.setSex(SexEnum.MALE);
        account.setIdcardNo(codecKit.encodeBase64("510112198403236016"));
        account.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        account.setNickname("Eugene");
        account.setMobile(codecKit.encodeBase64("18980840323"));
        this.accountService.save(account);
    }

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
