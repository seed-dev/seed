package com.github.seedm.test.repository;

import com.github.pagehelper.PageHelper;
import com.github.seedm.entities.enumeration.SexEnum;
import com.github.seedm.entities.enumeration.StatusEnum;
import com.github.seedm.repository.entities.param.AccountParam;
import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.entities.vo.AccountVo;
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
        List<AccountParam> accounts = new ArrayList<>();
        AccountParam account = new AccountParam();
        account.setId(testId);
        account.setName("测试用户");
        account.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        account.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1989-02-18"));
        account.setSex(SexEnum.MALE);
        account.setIdcardNo(codecKit.encodeBase64("5100078888888890"));
        account.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        account.setNickname("SuperAdmin");
        account.setMobile(codecKit.encodeBase64("139000000002"));
        accounts.add(account);

        for (int i = 0; i < 30; i++) {
            AccountParam temp = new AccountParam();
            temp.setId(stringKit.uuid(true));
            temp.setName("测试用户" + (i + 1));
            temp.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
            temp.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1989-02-18"));
            if(i % 2 == 0) {
                temp.setSex(SexEnum.MALE);
            } else {
                temp.setSex(SexEnum.FEMALE);
            }
            temp.setIdcardNo(codecKit.encodeBase64("510007888888889" + (i + 1)));
            temp.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
            temp.setNickname("Test" + (i + 1));
            temp.setMobile(codecKit.encodeBase64("13900000000" + (i + 1)));
            accounts.add(temp);
        }

        int result = this.accountMapper.insertMulti(accounts);

        Assert.assertEquals(31, result);
    }

//    @Test
//    @Rollback(false)
//    public void initAccount() throws ParseException {
//        AccountParam account = new AccountParam();
//        account.setId(stringKit.uuid(true));
//        account.setName("陈志恒");
//        account.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
//        account.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-03-23"));
//        account.setSex(SexEnum.MALE);
//        account.setIdcardNo(codecKit.encodeBase64("510112198403236016"));
//        account.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
//        account.setNickname("Eugene");
//        account.setMobile(codecKit.encodeBase64("18980840323"));
//        this.accountMapper.insert(account);
//    }

    @Test
    public void testInsert() throws ParseException {
        AccountParam account = new AccountParam();
        account.setId(stringKit.uuid(true));
        account.setName("超级管理员");
        account.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        account.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-03-08"));
        account.setSex(SexEnum.FEMALE);
        account.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        account.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        account.setNickname("SuperAdmin");
        account.setMobile(codecKit.encodeBase64("139000000000"));
        int result = this.accountMapper.insert(account);

        Assert.assertEquals(1, result);
    }

    @Test
    public void insertMulti() throws ParseException {
        AccountParam superAdmin = new AccountParam();
        superAdmin.setId(stringKit.uuid(true));
        superAdmin.setName("超级管理员");
        superAdmin.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        superAdmin.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-03-08"));
        superAdmin.setSex(SexEnum.MALE);
        superAdmin.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        superAdmin.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        superAdmin.setNickname("SuperAdmin");
        superAdmin.setMobile(codecKit.encodeBase64("139000000000"));

        AccountParam admin = new AccountParam();
        admin.setId(stringKit.uuid(true));
        admin.setName("管理员");
        admin.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        admin.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1988-01-08"));
        admin.setSex(SexEnum.MALE);
        admin.setIdcardNo(codecKit.encodeBase64("5100078888888889"));
        admin.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        admin.setNickname("Admin");
        admin.setMobile(codecKit.encodeBase64("139000000001"));

        List<AccountParam> accounts = new ArrayList<>();
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
        Assert.assertEquals(31, accounts.size());

        PageHelper.startPage(1, 10);
        accounts = this.accountMapper.selectAll();
        Assert.assertEquals(10, accounts.size());
    }

    @Test
    public void testSelectActive() {
        AccountParam account = new AccountParam();
        account.setName("测试");
        List<AccountVo> accounts = this.accountMapper.selectAllByCriteria(account);
        Assert.assertEquals(31, accounts.size());

        account.setStatus(StatusEnum.DISABLED);
        accounts = this.accountMapper.selectAllByCriteria(account);
        Assert.assertEquals(0, accounts.size());

        account.setName(null);
        account.setMobile(codecKit.encodeBase64("139"));
        account.setStatus(StatusEnum.ACTIVATE);
        accounts = this.accountMapper.selectAllByCriteria(account);
        Assert.assertEquals(31, accounts.size());

        account.setSex(SexEnum.MALE);
        accounts = this.accountMapper.selectAllByCriteria(account);
        Assert.assertEquals(16, accounts.size());

    }
}
