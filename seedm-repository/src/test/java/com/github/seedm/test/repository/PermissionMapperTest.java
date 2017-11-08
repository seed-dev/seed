package com.github.seedm.test.repository;


import com.github.seedm.repository.mapper.seed.IPermissionMapper;
import com.github.seedm.repository.entities.vo.PermissionVo;
import com.github.toolkit.core.StringKit;
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
public class PermissionMapperTest {

    @Autowired
    private IPermissionMapper permissionMapper;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforeClass(){
        stringKit = new StringKit();
    }

    @Test
//    @Rollback(false)
    public void testInitData() {

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

        this.permissionMapper.insertMulti(permissions);
    }
}
