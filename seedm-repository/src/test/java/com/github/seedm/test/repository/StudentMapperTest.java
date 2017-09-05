package com.github.seedm.test.repository;

import com.github.seedm.entities.enumeration.SexEnum;
import com.github.seedm.repository.mapper.seed.IStudentMapper;
import com.github.seedm.repository.vo.seed.StudentVo;
import com.github.toolkit.core.CodecKit;
import com.github.toolkit.core.StringKit;
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

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Test
//    @Rollback(false)
    public void testInitAccount() {
        List<StudentVo> students = new ArrayList<>();
        StudentVo eugene = new StudentVo();
        eugene.setId(stringKit.uuid(true));
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
        kily.setName("克莉");
        kily.setSex(SexEnum.FEMALE);
        kily.setBirthday(new Date());
        kily.setIdcardNo(codecKit.encodeBase64("5100078888888890"));

        students.add(eugene);
        students.add(king);
        students.add(kily);
        this.studentMapper.insertMulti(students);
    }

    @Test
    public void testInsert() {

    }
}
