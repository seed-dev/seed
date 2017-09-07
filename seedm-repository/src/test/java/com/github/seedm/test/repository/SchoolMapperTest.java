package com.github.seedm.test.repository;


import com.github.seedm.entities.enumeration.StatusEnum;
import com.github.seedm.repository.mapper.seed.ISchoolMapper;
import com.github.seedm.repository.mapper.seed.ISemesterMapper;
import com.github.seedm.repository.vo.seed.SchoolVo;
import com.github.seedm.repository.vo.seed.SemesterVo;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class SchoolMapperTest {

    @Autowired
    private ISchoolMapper schoolMapper;

    @Autowired
    private ISemesterMapper semesterMapper;

    private static StringKit stringKit;

    private String testId;
    private String testSemesterId;

    @BeforeClass
    public static void beforeClass(){
        stringKit = new StringKit();
    }

    @Before
    public void before() throws ParseException {
        this.testId = stringKit.uuid(true);
        this.testSemesterId = stringKit.uuid(true);
        List<SchoolVo> schools = new ArrayList<>();
        SchoolVo school1 = new SchoolVo();
        school1.setId(this.testId);
        school1.setName("训练营01");
        school1.setAddress("火星星系路1号");
        school1.setIntro("这里是一所全能的足球实训学院，提供魔鬼式的全能训练01");
        school1.setContactNo("0223-89898989");

        SchoolVo school2 = new SchoolVo();
        school2.setId(stringKit.uuid(true));
        school2.setName("训练营02");
        school2.setAddress("水星星系路2号");
        school2.setIntro("这里是一所全能的足球实训学院，提供魔鬼式的全能训练02");
        school2.setContactNo("0222-56565656");

        schools.add(school1);
        schools.add(school2);
        int count = this.schoolMapper.insertMulti(schools);
        Assert.assertEquals(2, count);

        SemesterVo semester1 = new SemesterVo(this.testSemesterId, "第一学期", this.testId, StatusEnum.DISABLED, new SimpleDateFormat("yyyy-MM-dd").parse("2017-02-10"), new SimpleDateFormat("yyyy-MM-dd").parse("2017-07-12"));
        SemesterVo semester2 = new SemesterVo(stringKit.uuid(true), "第二学期", this.testId, StatusEnum.ACTIVATE, new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-03"), new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-25"));

        count = this.semesterMapper.insert(semester1);
        Assert.assertEquals(1, count);
        count = this.semesterMapper.insert(semester2);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testInsert() {
        SchoolVo schoolVo = new SchoolVo();
        String id = stringKit.uuid(true);
        schoolVo.setId(id);
        schoolVo.setName("ACMilan学院");
        schoolVo.setAddress("意大利米兰城区");
        schoolVo.setIntro("这里是一所全能的足球实训学院，提供魔鬼式的技能训练");
        schoolVo.setContactNo("0223-89898989");

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
        school1.setContactNo("0223-89898989");

        SchoolVo school2 = new SchoolVo();
        school2.setId(stringKit.uuid(true));
        school2.setName("Xkilin修炼学院2");
        school2.setAddress("水星星系路2号");
        school2.setIntro("这里是一所全能的研发语言实训学院，提供魔鬼式的编码训练2");
        school2.setContactNo("0222-56565656");

        schools.add(school1);
        schools.add(school2);
        int count = this.schoolMapper.insertMulti(schools);

        //断言新增数据条数
        Assert.assertEquals(2, count);
    }

    @Test
    public void testDeleteById() {
        int count = this.schoolMapper.deleteById(this.testId);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testUpdate() {
        SchoolVo schoolVo = this.schoolMapper.selectById(this.testId);
        Assert.assertNotNull(schoolVo);
        Assert.assertEquals("0223-89898989", schoolVo.getContactNo());

        schoolVo.setContactNo("0222-90909090");
        int count = this.schoolMapper.update(schoolVo);
        Assert.assertEquals(1, count);
        schoolVo = this.schoolMapper.selectById(this.testId);
        Assert.assertEquals("0222-90909090", schoolVo.getContactNo());
    }

    @Test
    public void testSelectById() {
        SchoolVo schoolVo = this.schoolMapper.selectById(this.testId);
        Assert.assertNotNull(schoolVo);
    }

    @Test
    public void testSelectWithSemesterById() {
        SchoolVo schoolVo = this.schoolMapper.selectWithSemesterById(this.testId);
        Assert.assertNotNull(schoolVo);
        Assert.assertEquals(this.testId, schoolVo.getId());
        Assert.assertEquals(2, schoolVo.getSemesters().size());
    }

    @Test
    public void testSelectAll() {
        int count = this.schoolMapper.selectAll().size();

        //断言新增数据在数据库中的条数
        Assert.assertEquals(2, count);
    }

    @Test
    public void testSelectAllByCriteria() {
        SchoolVo schoolVo = new SchoolVo();
        schoolVo.setName("01");
        List<SchoolVo> schools = this.schoolMapper.selectAllByCriteria(schoolVo);
        Assert.assertEquals(1, schools.size());

        schoolVo.setContactNo("0223");
        schools = this.schoolMapper.selectAllByCriteria(schoolVo);
        Assert.assertEquals(1, schools.size());

        schoolVo.setContactNo("0222");
        schools = this.schoolMapper.selectAllByCriteria(schoolVo);
        Assert.assertEquals(0, schools.size());

        schoolVo.setName("02");
        schoolVo.setAddress("水星");
        schools = this.schoolMapper.selectAllByCriteria(schoolVo);
        Assert.assertEquals(1, schools.size());
    }
}
