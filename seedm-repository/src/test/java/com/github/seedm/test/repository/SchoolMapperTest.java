package com.github.seedm.test.repository;


import com.github.seedm.repository.mapper.seed.ISchoolMapper;
import com.github.seedm.repository.vo.seed.SchoolVo;
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
        SchoolVo schoolVo = new SchoolVo();
        String id = stringKit.uuid(true);
        schoolVo.setId(id);
        schoolVo.setName("Xkilin修炼学院");
        schoolVo.setAddress("火星星系路1号");
        schoolVo.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练");
        schoolVo.setContactNumber("0223-89898989");

        int count = this.schoolMapper.insert(schoolVo);

        //断言新增数据存在于数据库中
        Assert.assertEquals(1, count);
    }

    @Test
    public void testInsertMulti() {
        List<SchoolVo> schools = new ArrayList<>();
        SchoolVo school1 = new SchoolVo();
        school1.setId(stringKit.uuid(true));
        school1.setName("Xkilin修炼学院1");
        school1.setAddress("火星星系路1号");
        school1.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练1");
        school1.setContactNumber("0223-89898989");

        SchoolVo school2 = new SchoolVo();
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
        SchoolVo schoolVo = new SchoolVo();
        String id = stringKit.uuid(true);
        schoolVo.setId(id);
        schoolVo.setName("Xkilin修炼学院x");
        schoolVo.setAddress("火星星系路1号");
        schoolVo.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练1");
        schoolVo.setContactNumber("0223-89898989");

        this.schoolMapper.insert(schoolVo);
        int count = this.schoolMapper.deleteById(id);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testUpdate() {
        SchoolVo schoolVo = new SchoolVo();
        String id = stringKit.uuid(true);
        schoolVo.setId(id);
        schoolVo.setName("Xkilin修炼学院");
        schoolVo.setAddress("火星星系路1号");
        schoolVo.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练");
        schoolVo.setContactNumber("0223-89898989");

        this.schoolMapper.insert(schoolVo);
        schoolVo = this.schoolMapper.selectById(id);
        Assert.assertNotNull(schoolVo);
        schoolVo.setContactNumber("0222-90909090");
        schoolVo = this.schoolMapper.selectById(id);
        Assert.assertEquals("0222-90909090", schoolVo.getContactNumber());
    }

    @Test
    public void testSelectAll() {
        List<SchoolVo> schools = new ArrayList<>();
        SchoolVo school1 = new SchoolVo();
        school1.setId(stringKit.uuid(true));
        school1.setName("Xkilin修炼学院1");
        school1.setAddress("火星星系路1号");
        school1.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练1");
        school1.setContactNumber("0223-89898989");

        SchoolVo school2 = new SchoolVo();
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
