package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.seed.StudentVo;

import java.util.List;

/**
 * 学生信息表操作映射定义
 * @author Eugene
 */
public interface IStudentMapper {

    /**
     * 新增学生信息
     * @param studentVo 学生信息
     * @return 成功新增学生信息条数
     */
    public int insert(StudentVo studentVo);

    /**
     * 批量新增学生信息
     * @param students 学生信息集合
     * @return 成功新增学生信息条数
     */
    public int insertMulti(List<StudentVo> students);

    /**
     * 删除指定ID的学生信息
     * @param id 学生信息ID
     * @return 成功删除学生信息条数
     */
    public int deleteById(String id);

    /**
     * 更新学生信息
     * @param studentVo 学生信息
     * @return 成功更新学生信息条数
     */
    public int update(StudentVo studentVo);

    /**
     * 根据ID查询学生信息
     * @param id 学生信息ID
     * @return 学生信息
     */
    public StudentVo selectById(String id);

    /**
     * 查询全部学生信息
     * @return 系统全部学生信息列表
     */
    public List<StudentVo> selectAll();

    /**
     * 查询学生信息，使用复合条件过滤
     * @param studentVo 学生信息
     * @return 学生信息列表
     */
    public List<StudentVo> selectAllByCriteria(StudentVo studentVo);
}
