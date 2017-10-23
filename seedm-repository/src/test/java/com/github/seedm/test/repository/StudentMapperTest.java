package com.github.seedm.test.repository;

import com.github.seedm.entities.enumeration.SexEnum;
import com.github.seedm.repository.mapper.seed.IStudentMapper;
import com.github.seedm.repository.entities.vo.seed.StudentVo;
import com.github.toolkit.core.CodecKit;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
@Transactional
public class StudentMapperTest {

    @Autowired
    private IStudentMapper studentMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    private String testStudentId;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Before
    public void before() {
        this.testStudentId = stringKit.uuid(true);
        List<StudentVo> students = new ArrayList<>();
        StudentVo eugene = new StudentVo();
        eugene.setId(this.testStudentId);
        eugene.setName("张三");
        eugene.setSex(SexEnum.MALE);
        eugene.setBirthday(new Date());
        eugene.setIdcardNo(codecKit.encodeBase64("5100078888888888"));

        StudentVo king = new StudentVo();
        king.setId(stringKit.uuid(true));
        king.setName("国王");
        king.setSex(SexEnum.MALE);
        king.setBirthday(new Date());
        king.setIdcardNo(codecKit.encodeBase64("5100078888888889"));

        StudentVo kily = new StudentVo();
        kily.setId(stringKit.uuid(true));
        kily.setName("凯莉");
        kily.setSex(SexEnum.FEMALE);
        kily.setBirthday(new Date());
        kily.setIdcardNo(codecKit.encodeBase64("5100078888888890"));

        students.add(eugene);
        students.add(king);
        students.add(kily);
        int count = this.studentMapper.insertMulti(students);
        Assert.assertEquals(3, count);
    }

    @Test
    public void testInsert() {
        StudentVo studentVo = new StudentVo();
        studentVo.setId(stringKit.uuid(true));
        studentVo.setName("测试学生");
        studentVo.setSex(SexEnum.FEMALE);
        studentVo.setBirthday(new Date());
        studentVo.setIdcardNo(codecKit.encodeBase64("5100078888888896"));

        int count = this.studentMapper.insert(studentVo);
        Assert.assertEquals(1, count);
    }

    @Test
    public void insertMulti() {
        this.testStudentId = stringKit.uuid(true);
        List<StudentVo> students = new ArrayList<>();
        StudentVo eugene = new StudentVo();
        eugene.setId(this.testStudentId);
        eugene.setName("学生01");
        eugene.setSex(SexEnum.MALE);
        eugene.setBirthday(new Date());
        eugene.setIdcardNo(codecKit.encodeBase64("5100078888888899"));

        StudentVo king = new StudentVo();
        king.setId(stringKit.uuid(true));
        king.setName("学生02");
        king.setSex(SexEnum.MALE);
        king.setBirthday(new Date());
        king.setIdcardNo(codecKit.encodeBase64("5100078888888800"));

        students.add(eugene);
        students.add(king);
        int count = this.studentMapper.insertMulti(students);
        Assert.assertEquals(2, count);
    }

    @Test
    public void testDeleteById() {
        StudentVo student = this.studentMapper.selectById(this.testStudentId);
        Assert.assertNotNull(student);

        int count = this.studentMapper.deleteById(student.getId());
        Assert.assertEquals(1, count);
    }

    @Test
    public void testSelectById() {
        StudentVo student = this.studentMapper.selectById(this.testStudentId);
        Assert.assertNotNull(student);
        Assert.assertEquals("张三", student.getName());
    }

    @Test
    public void testSelectAll() {
        List<StudentVo> students = this.studentMapper.selectAll();
        Assert.assertNotNull(students);
        Assert.assertEquals(3, students.size());
    }

    @Test
    public void testSelectAllByCriteria() {
        StudentVo studentCriteria = new StudentVo();
        studentCriteria.setName("张");

        List<StudentVo> students = this.studentMapper.selectAllByCriteria(studentCriteria);
        Assert.assertNotNull(students);
        Assert.assertEquals(1, students.size());
    }
}
