package com.github.seedm.test.repository;

import com.github.pagehelper.PageHelper;
import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.toolkit.core.CodecKit;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class AccountMapperTest {

    @Autowired
    private IAccountMapper accountMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    //测试用户ID
    private String testId;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Before
    public void befor() throws ParseException {
        this.testId = stringKit.uuid(true);
        List<AccountVo> accounts = new ArrayList<>();
        AccountVo accountVo = new AccountVo();
        accountVo.setId(testId);
        accountVo.setName("测试用户");
        accountVo.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        accountVo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1989-02-18"));
        accountVo.setIdcardNo(codecKit.encodeBase64("5100078888888890"));
        accountVo.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        accountVo.setNickname("SuperAdmin");
        accountVo.setMobile(codecKit.encodeBase64("139000000002"));
        accounts.add(accountVo);

        for (int i = 0; i < 30; i++) {
            AccountVo temp = new AccountVo();
            temp.setId(stringKit.uuid(true));
            temp.setName("测试用户" + (i + 1));
            temp.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
            temp.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1989-02-18"));
            temp.setIdcardNo(codecKit.encodeBase64("510007888888889" + (i + 1)));
            temp.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
            temp.setNickname("Test" + (i + 1));
            temp.setMobile(codecKit.encodeBase64("13900000000" + (i + 1)));
            accounts.add(temp);
        }

        int result = this.accountMapper.insertMulti(accounts);

        Assert.assertEquals(31, result);
    }

    @Test
    public void testInsert() throws ParseException {
        AccountVo accountVo = new AccountVo();
        accountVo.setId(stringKit.uuid(true));
        accountVo.setName("超级管理员");
        accountVo.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        accountVo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-03-08"));
        accountVo.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        accountVo.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        accountVo.setNickname("SuperAdmin");
        accountVo.setMobile(codecKit.encodeBase64("139000000000"));
        int result = this.accountMapper.insert(accountVo);

        Assert.assertEquals(1, result);
    }

    @Test
    public void insertMulti() throws ParseException {
        AccountVo superAdmin = new AccountVo();
        superAdmin.setId(stringKit.uuid(true));
        superAdmin.setName("超级管理员");
        superAdmin.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        superAdmin.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-03-08"));
        superAdmin.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        superAdmin.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        superAdmin.setNickname("SuperAdmin");
        superAdmin.setMobile(codecKit.encodeBase64("139000000000"));

        AccountVo admin = new AccountVo();
        admin.setId(stringKit.uuid(true));
        admin.setName("管理员");
        admin.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        admin.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1988-01-08"));
        admin.setIdcardNo(codecKit.encodeBase64("5100078888888889"));
        admin.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        admin.setNickname("Admin");
        admin.setMobile(codecKit.encodeBase64("139000000001"));

        List<AccountVo> accounts = new ArrayList<>();
        accounts.add(superAdmin);
        accounts.add(admin);

        int result = this.accountMapper.insertMulti(accounts);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testDeleteById() throws ParseException {
        AccountVo account = this.accountMapper.selectById(this.testId);
        Assert.assertNotNull(account);
        int count = this.accountMapper.deleteById(account.getId());
        Assert.assertEquals(1, count);
    }

    @Test
    public void testUpdate() throws ParseException {
        AccountVo account = this.accountMapper.selectById(this.testId);
        Assert.assertNotNull(account);
        Assert.assertEquals("139000000002", codecKit.decodeBase64(account.getMobile()));

        account.setMobile(codecKit.encodeBase64("189000000000"));
        int count = this.accountMapper.update(account);
        Assert.assertEquals(1, count);

        account = this.accountMapper.selectById(this.testId);
        Assert.assertNotNull(account);
        Assert.assertEquals("189000000000", codecKit.decodeBase64(account.getMobile()));
    }

    @Test
    public void testSelectById() throws ParseException {
        AccountVo account = this.accountMapper.selectById(this.testId);
        Assert.assertNotNull(account);
    }

    @Test
    public void testSelectAll() {
        List<AccountVo> accounts = this.accountMapper.selectAll();
        Assert.assertEquals(34, accounts.size());

        PageHelper.startPage(1, 10);
        accounts = this.accountMapper.selectAll();
        Assert.assertEquals(10, accounts.size());
    }

    @Test
    public void testSelectActive() {
        AccountVo accountVo = new AccountVo();
//        accountVo.setUserId("super");
        accountVo.setMobile(codecKit.encodeBase64("139000000000"));
        List<AccountVo> accounts = this.accountMapper.selectAllByCriteria(accountVo);
    }
}
