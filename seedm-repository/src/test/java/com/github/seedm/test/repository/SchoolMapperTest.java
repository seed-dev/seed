package com.github.seedm.test.repository;


import com.github.seedm.repository.mapper.seed.ISchoolMapper;
import com.github.seedm.repository.vo.seed.SchoolVO;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
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
public class SchoolMapperTest {

    @Autowired
    private ISchoolMapper schoolMapper;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforeClass(){
        stringKit = new StringKit();
    }

    @Test
    public void testInsert() {
        SchoolVO schoolVO = new SchoolVO();
        String id = stringKit.uuid(true);
        schoolVO.setId(id);
        schoolVO.setName("Xkilin修炼学院");
        schoolVO.setAddress("火星星系路1号");
        schoolVO.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练");
        schoolVO.setContactNumber("0223-89898989");

        int count = this.schoolMapper.insert(schoolVO);

        //断言新增数据存在于数据库中
        Assert.assertEquals(1, count);
    }

    @Test
    public void testInsertMulti() {
        List<SchoolVO> schools = new ArrayList<>();
        SchoolVO school1 = new SchoolVO();
        school1.setId(stringKit.uuid(true));
        school1.setName("Xkilin修炼学院1");
        school1.setAddress("火星星系路1号");
        school1.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练1");
        school1.setContactNumber("0223-89898989");

        SchoolVO school2 = new SchoolVO();
        school2.setId(stringKit.uuid(true));
        school2.setName("Xkilin修炼学院2");
        school2.setAddress("火星星系路2号");
        school2.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练2");
        school2.setContactNumber("0223-56565656");

        schools.add(school1);
        schools.add(school2);
        int count = this.schoolMapper.insertMulti(schools);

        //断言新增数据条数
        Assert.assertEquals(2, count);
    }

    @Test
    public void testDeleteById() {
        SchoolVO schoolVO = new SchoolVO();
        String id = stringKit.uuid(true);
        schoolVO.setId(id);
        schoolVO.setName("Xkilin修炼学院x");
        schoolVO.setAddress("火星星系路1号");
        schoolVO.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练1");
        schoolVO.setContactNumber("0223-89898989");

        this.schoolMapper.insert(schoolVO);
        int count = this.schoolMapper.deleteById(id);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testUpdate() {
        SchoolVO schoolVO = new SchoolVO();
        String id = stringKit.uuid(true);
        schoolVO.setId(id);
        schoolVO.setName("Xkilin修炼学院");
        schoolVO.setAddress("火星星系路1号");
        schoolVO.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练");
        schoolVO.setContactNumber("0223-89898989");

        this.schoolMapper.insert(schoolVO);
        schoolVO = this.schoolMapper.selectById(id);
        Assert.assertNotNull(schoolVO);
        schoolVO.setContactNumber("0222-90909090");
        schoolVO = this.schoolMapper.selectById(id);
        Assert.assertEquals("0222-90909090", schoolVO.getContactNumber());
    }

    @Test
    public void testSelectAll() {
        List<SchoolVO> schools = new ArrayList<>();
        SchoolVO school1 = new SchoolVO();
        school1.setId(stringKit.uuid(true));
        school1.setName("Xkilin修炼学院1");
        school1.setAddress("火星星系路1号");
        school1.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练1");
        school1.setContactNumber("0223-89898989");

        SchoolVO school2 = new SchoolVO();
        school2.setId(stringKit.uuid(true));
        school2.setName("Xkilin修炼学院2");
        school2.setAddress("火星星系路2号");
        school2.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练2");
        school2.setContactNumber("0223-56565656");

        schools.add(school1);
        schools.add(school2);

        this.schoolMapper.insertMulti(schools);
        int count = this.schoolMapper.selectAll().size();

        //断言新增数据在数据库中的条数
        Assert.assertEquals(2, count);
    }
}
