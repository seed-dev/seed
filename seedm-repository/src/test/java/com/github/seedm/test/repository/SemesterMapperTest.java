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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class SemesterMapperTest {

    @Autowired
    private ISemesterMapper semesterMapper;

    @Autowired
    private ISchoolMapper schoolMapper;

    private static StringKit stringKit;

    private String testSchoolId;
    private String testSemesterId;

    @BeforeClass
    public static void beforeClass(){
        stringKit = new StringKit();
    }

    @Before
    public void before() throws ParseException {
        this.testSchoolId = stringKit.uuid(true);
        this.testSemesterId = stringKit.uuid(true);
        SchoolVo school = new SchoolVo();
        school.setId(this.testSchoolId);
        school.setName("Milan测试基地");
        school.setAddress("意大利米兰Via Aldo Rossi大街8号");
        school.setIntro("舒适、开放、富有激情的办公空间则是承载并解决这些问题的物质空间，因而球队的标志性红黑配色自然成为这幢七层楼建筑的主要设计元素，且除了办公区域，Casa Milan 还包括有餐厅、周边商店、博物馆等，以期提供给球迷们一个更加贴近球队文化的场所");
        school.setContactNo("+39 02 62281");

        SemesterVo semester1 = new SemesterVo(this.testSemesterId, "第一学期", this.testSchoolId, StatusEnum.DISABLED, new SimpleDateFormat("yyyy-MM-dd").parse("2017-02-10"), new SimpleDateFormat("yyyy-MM-dd").parse("2017-07-12"));
        SemesterVo semester2 = new SemesterVo(stringKit.uuid(true), "第二学期", this.testSchoolId, StatusEnum.ACTIVATE, new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-03"), new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-25"));

        int count = this.schoolMapper.insert(school);
        Assert.assertEquals(1, count);

        count = this.semesterMapper.insert(semester1);
        Assert.assertEquals(1, count);
        count = this.semesterMapper.insert(semester2);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testInsert() throws ParseException {
        SemesterVo semester1 = new SemesterVo(stringKit.uuid(true), "第一学期", this.testSchoolId, StatusEnum.DISABLED, new SimpleDateFormat("yyyy-MM-dd").parse("2017-02-10"), new SimpleDateFormat("yyyy-MM-dd").parse("2017-07-12"));
        int count = this.semesterMapper.insert(semester1);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testSelectById() {
        SemesterVo semesterVo = this.semesterMapper.selectById(this.testSemesterId);
        Assert.assertNotNull(semesterVo);
        Assert.assertEquals("第一学期", semesterVo.getName());
        Assert.assertEquals(-1, semesterVo.getStatus().getStatus());
        Assert.assertNotNull(semesterVo.getSchool());
        Assert.assertEquals(this.testSchoolId, semesterVo.getSchool().getId());
    }
}
