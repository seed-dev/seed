package com.github.seedm.test.repository;


import com.github.seedm.repository.mapper.ISysProvincesMapper;
import com.github.seedm.repository.entities.vo.SysProvincesVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class SysProvincesMapperTest {

    @Autowired
    private ISysProvincesMapper sysProvincesMapper;

    @Test
    public void testSelectAll() {
        List<SysProvincesVO> sysProvinces = this.sysProvincesMapper.selectAll();
        Assert.assertEquals(34, sysProvinces.size());
    }
}
