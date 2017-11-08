package com.github.seedm.repository.mapper;

import com.github.seedm.repository.entities.vo.SemesterStudentVo;

/**
 * 学期学生关系表操作映射定义
 * @author Eugene
 */
public interface ISemesterStudentMapper {

    public int insert(SemesterStudentVo semesterStudentVo);
}
