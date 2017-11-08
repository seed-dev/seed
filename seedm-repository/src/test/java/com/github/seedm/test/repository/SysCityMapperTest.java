package com.github.seedm.test.repository;


import com.github.seedm.repository.mapper.ISysCityMapper;
import com.github.seedm.repository.entities.vo.SysCityVO;
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
public class SysCityMapperTest {

    @Autowired
    private ISysCityMapper sysCityMapper;

    @Test
    public void testSelectByProvince() {
        //查询四川省的所有市级
        List<SysCityVO> sysCities = this.sysCityMapper.selectByProvince("510000");

        //总共21个市级
        Assert.assertEquals(21, sysCities.size());
    }
}
