package com.github.seedm.test.repository;

import com.github.seedm.repository.mapper.seed.ISchoolRoleMapper;
import com.github.seedm.repository.vo.seed.SchoolRoleVo;
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
public class SchoolRoleMapperTest {

    @Autowired
    private ISchoolRoleMapper schoolRoleMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Test
    public void testInsert() {
//        SchoolRoleVo schoolRoleVo = new SchoolRoleVo(stringKit.uuid(true), "84961878dadc41fc8c3553f0de76eaa8", "076aeb9d097b4a6187f7497028dbaf83");
        SchoolRoleVo schoolRoleVo = new SchoolRoleVo(stringKit.uuid(true), "84961878dadc41fc8c3553f0de76eaa8", "357a91e6f92e40a6bb0039f398788d85");
        int count = this.schoolRoleMapper.insert(schoolRoleVo);
        Assert.assertEquals(1, count);
    }
}
