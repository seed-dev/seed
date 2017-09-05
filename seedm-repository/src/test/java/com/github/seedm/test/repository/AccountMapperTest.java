package com.github.seedm.test.repository;

import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.toolkit.core.CodecKit;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class AccountMapperTest {

    @Autowired
    private IAccountMapper accountMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

//    @Test
    public void testInitAccount() {
        List<AccountVo> accounts = new ArrayList<>();
        AccountVo admin = new AccountVo();
        admin.setId(stringKit.uuid(true));
        admin.setName("超级管理员");
        admin.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        admin.setBirthday(new Date());
        admin.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        admin.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        admin.setNickname("管理员");
        admin.setMobile(codecKit.encodeBase64("139000000000"));

        AccountVo nesta = new AccountVo();
        nesta.setId(stringKit.uuid(true));
        nesta.setName("内斯塔");
        nesta.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        nesta.setBirthday(new Date());
        nesta.setIdcardNo(codecKit.encodeBase64("5100076666666666"));
        nesta.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        nesta.setNickname("nesta");
        nesta.setMobile(codecKit.encodeBase64("139000000001"));

        AccountVo suso = new AccountVo();
        suso.setId(stringKit.uuid(true));
        suso.setName("苏索");
        suso.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        suso.setBirthday(new Date());
        suso.setIdcardNo(codecKit.encodeBase64("5100075555555555"));
        suso.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        suso.setNickname("nesta");
        suso.setMobile(codecKit.encodeBase64("139000000002"));

        accounts.add(admin);
        accounts.add(nesta);
        accounts.add(suso);
        this.accountMapper.insertMulti(accounts);
    }

    @Test
    public void testInsert() {
        AccountVo accountVo = new AccountVo();
        accountVo.setId(UUID.randomUUID().toString());
        accountVo.setName("超级管理员");
        accountVo.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        accountVo.setBirthday(new Date());
        accountVo.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        accountVo.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        accountVo.setNickname("管理员");
        accountVo.setMobile(codecKit.encodeBase64("139000000000"));
        this.accountMapper.insert(accountVo);

//        List<AccountVo> result = this.accountMapper.selectAll();
//        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testSelectActive() {
        AccountVo accountVo = new AccountVo();
//        accountVo.setUserId("super");
        accountVo.setMobile(codecKit.encodeBase64("139000000000"));
        AccountVo result = this.accountMapper.selectActiveAccounts(accountVo);
        System.out.println(result.getName());
    }

    @Test
    public void testSelectAll() {
//        PageHelper.startPage(1, 5);
//        PageHelper.offsetPage(1, 5);
        List<AccountVo> accounts = this.accountMapper.selectAll();
        System.out.println(accounts.size());
        Assert.assertEquals(1, accounts.size());
    }
}
