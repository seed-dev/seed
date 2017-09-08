package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.seed.SemesterStudentVo;

/**
 * 学期学生关系表操作映射定义
 * @author Eugene
 */
public interface ISemesterStudentMapper {

    public int insert(SemesterStudentVo semesterStudentVo);
}
