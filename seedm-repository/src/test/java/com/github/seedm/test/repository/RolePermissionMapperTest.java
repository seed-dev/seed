package com.github.seedm.test.repository;

import com.github.seedm.repository.mapper.seed.IRolePermissionMapper;
import com.github.seedm.repository.entities.vo.seed.RolePermissionVo;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class RolePermissionMapperTest {

    @Autowired
    private IRolePermissionMapper rolePermissionMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Test
    public void testInsert() {
        RolePermissionVo rolePermissionVo = new RolePermissionVo(stringKit.uuid(true), "84961878dadc41fc8c3553f0de76eaa8", "357a91e6f92e40a6bb0039f398788d85");
        int count = this.rolePermissionMapper.insert(rolePermissionVo);
        Assert.assertEquals(1, count);
    }
}
