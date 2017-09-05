package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.seed.AccountVo;
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
     * 查询全部学生信息
     * @return 系统全部学生信息列表
     */
    public List<StudentVo> selectAll();

    /**
     * 查询学生信息，指定复合条件，仅查看当前激活学生
     * @param studentVo 学生信息
     * @return 学生信息
     */
    public AccountVo selectActiveStudent(StudentVo studentVo);

//    /**
//     * 查询学生信息，指定复合条件，不区分激活和非激活学生
//     * @param studentVo 账号信息
//     * @return 账号信息
//     */
//    public AccountVo selectStudent(StudentVo studentVo);
}
