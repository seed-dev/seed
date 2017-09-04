package com.github.seedm.test.repository;


import com.github.seedm.entities.enumeration.RoleEnum;
import com.github.seedm.repository.mapper.seed.IRoleMapper;
import com.github.seedm.repository.vo.seed.RoleVo;
import com.github.seedm.repository.vo.seed.SchoolVo;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class RoleMapperTest {

    @Autowired
    private IRoleMapper roleMapper;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforeClass(){
        stringKit = new StringKit();
    }

    @Test
    @Rollback(false)
    public void testInsert() {
        RoleVo roleVo = new RoleVo();
        roleVo.setId(stringKit.uuid(true));
        roleVo.setName("老师");
        roleVo.setSign(RoleEnum.TEACHER);
        roleVo.setDescription("这是Milan学院的老师角色");

        int count = this.roleMapper.insert(roleVo);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testSelectById() {
        RoleVo roleVo = this.roleMapper.selectById("076aeb9d097b4a6187f7497028dbaf83");
        Assert.assertNotNull(roleVo);
    }
}
