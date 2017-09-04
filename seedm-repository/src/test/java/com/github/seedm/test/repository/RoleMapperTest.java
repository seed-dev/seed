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
    public void testInitData() {

        List<RoleVo> roles = new ArrayList<>();

        RoleVo principal = new RoleVo();
        principal.setId(stringKit.uuid(true));
        principal.setName("校长");
        principal.setSign(RoleEnum.PRINCIPAL);
        principal.setDescription("这是Milan学院的校长角色");

        RoleVo teacher = new RoleVo();
        teacher.setId(stringKit.uuid(true));
        teacher.setName("老师");
        teacher.setSign(RoleEnum.TEACHER);
        teacher.setDescription("这是Milan学院的老师角色");

        RoleVo instructor = new RoleVo();
        instructor.setId(stringKit.uuid(true));
        instructor.setName("辅导员");
        instructor.setSign(RoleEnum.INSTRUCTOR);
        instructor.setDescription("这是Milan学院的辅导员角色");

        RoleVo guardian = new RoleVo();
        guardian.setId(stringKit.uuid(true));
        guardian.setName("监护人");
        guardian.setSign(RoleEnum.GUARDIAN);
        guardian.setDescription("这是Milan学院的监护人角色");

        RoleVo student = new RoleVo();
        student.setId(stringKit.uuid(true));
        student.setName("学生");
        student.setSign(RoleEnum.STUDENT);
        student.setDescription("这是Milan学院的学生角色");

        roles.add(principal);
        roles.add(teacher);
        roles.add(instructor);
        roles.add(guardian);
        roles.add(student);

        this.roleMapper.insertMulti(roles);
    }

    @Test
    public void testInsert() {
        RoleVo roleVo = new RoleVo();
        roleVo.setId(stringKit.uuid(true));
        roleVo.setName("校长");
        roleVo.setSign(RoleEnum.PRINCIPAL);
        roleVo.setDescription("这是Milan学院的校长角色");

        int count = this.roleMapper.insert(roleVo);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testSelectById() {
        RoleVo roleVo = this.roleMapper.selectById("076aeb9d097b4a6187f7497028dbaf83");
        Assert.assertNotNull(roleVo);
    }
}
