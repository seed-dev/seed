package com.github.seedm.repository.mapper;

import com.github.seedm.repository.entities.vo.StudentSchoolVo;

/**
 * 学生学校关系表操作映射定义
 * @author Eugene
 */
public interface IStudentSchoolMapper {

    public int insert(StudentSchoolVo studentSchoolVo);
}
