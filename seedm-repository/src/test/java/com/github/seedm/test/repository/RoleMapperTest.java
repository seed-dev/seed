package com.github.seedm.test.repository;


import com.github.seedm.entities.enumeration.RoleEnum;
import com.github.seedm.repository.mapper.IPermissionMapper;
import com.github.seedm.repository.mapper.IRoleMapper;
import com.github.seedm.repository.mapper.IRolePermissionMapper;
import com.github.seedm.repository.entities.vo.PermissionVo;
import com.github.seedm.repository.entities.vo.RolePermissionVo;
import com.github.seedm.repository.entities.vo.RoleVo;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class RoleMapperTest {

    @Autowired
    private IRoleMapper roleMapper;

    @Autowired
    private IPermissionMapper permissionMapper;

    @Autowired
    private IRolePermissionMapper rolePermissionMapper;

    private static StringKit stringKit;

    private String teacherId;

    @BeforeClass
    public static void beforeClass(){
        stringKit = new StringKit();
    }

    @Before
    public void before() {
        //权限测试数据
        List<PermissionVo> permissions = new ArrayList<>();

        PermissionVo create = new PermissionVo();
        create.setId(stringKit.uuid(true));
        create.setName("创建账号");
        create.setSign("user:create");
        create.setDescription("这是Milan学院创建账号的权限");

        PermissionVo delete = new PermissionVo();
        delete.setId(stringKit.uuid(true));
        delete.setName("删除账号");
        delete.setSign("user:delete");
        delete.setDescription("这是Milan学院删除账号的权限");

        PermissionVo update = new PermissionVo();
        update.setId(stringKit.uuid(true));
        update.setName("更新账号");
        update.setSign("user:update");
        update.setDescription("这是Milan学院更新账号的权限");

        PermissionVo view = new PermissionVo();
        view.setId(stringKit.uuid(true));
        view.setName("查看账号");
        view.setSign("user:view");
        view.setDescription("这是Milan学院查看账号的权限");

        permissions.add(create);
        permissions.add(delete);
        permissions.add(update);
        permissions.add(view);

        int count = this.permissionMapper.insertMulti(permissions);
        Assert.assertEquals(4, count);

        //角色测试数据
        this.teacherId = stringKit.uuid(true);
        List<RoleVo> roles = new ArrayList<>();

        RoleVo principal = new RoleVo();
        principal.setId(stringKit.uuid(true));
        principal.setName("校长");
        principal.setSign(RoleEnum.PRINCIPAL);
        principal.setDescription("这是Milan学院的校长角色");

        RoleVo teacher = new RoleVo();
        teacher.setId(this.teacherId);
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

        count = this.roleMapper.insertMulti(roles);
        Assert.assertEquals(5, count);

        teacher.setPermissions(permissions);

        List<RolePermissionVo> rolePermissions = new ArrayList<>();
        //建立角色权限关系
        for (PermissionVo permissionVo : teacher.getPermissions()) {
            RolePermissionVo rolePermission = new RolePermissionVo(stringKit.uuid(true), this.teacherId, permissionVo.getId());
            rolePermissions.add(rolePermission);
        }

        count = this.rolePermissionMapper.insertMulti(rolePermissions);
        Assert.assertEquals(4, count);
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
        RoleVo roleVo = this.roleMapper.selectById(this.teacherId);
        Assert.assertNotNull(roleVo);
    }

    @Test
    public void testSelectWithPermissionById() {
        List<RoleVo> roles = this.roleMapper.selectWithPermissionById(this.teacherId);
        Assert.assertNotNull(roles);
    }
}
