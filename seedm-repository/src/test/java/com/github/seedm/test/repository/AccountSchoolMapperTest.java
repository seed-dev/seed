package com.github.seedm.test.repository;

import com.github.seedm.repository.mapper.seed.IAccountSchoolMapper;
import com.github.seedm.repository.vo.seed.AccountSchoolVo;
import com.github.toolkit.core.CodecKit;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class AccountSchoolMapperTest {

    @Autowired
    private IAccountSchoolMapper accountSchoolMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Test
    public void testInsert() {
        AccountSchoolVo accoutSchoolVo = new AccountSchoolVo(stringKit.uuid(true), "ef346482-c1a3-41e5-a924-dcb4ef214044", "84961878dadc41fc8c3553f0de76eaa8");
        int count = this.accountSchoolMapper.insert(accoutSchoolVo);
        Assert.assertEquals(1, count);
    }
}
