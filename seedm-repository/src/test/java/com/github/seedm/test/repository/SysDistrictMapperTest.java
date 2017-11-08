package com.github.seedm.test.repository;


import com.github.seedm.repository.mapper.seedsys.ISysDistrictMapper;
import com.github.seedm.repository.entities.vo.SysDistrictVO;
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
public class SysDistrictMapperTest {

    @Autowired
    private ISysDistrictMapper sysDistrictMapper;

    @Test
    public void testSelectByCityCode() {
        //查询四川省的所有市级
        List<SysDistrictVO> sysDistricts = this.sysDistrictMapper.selectByCityCode("510100");
        //总共20个市级
        Assert.assertEquals(20, sysDistricts.size());
    }
}
