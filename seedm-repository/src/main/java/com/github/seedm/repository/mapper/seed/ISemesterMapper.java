package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.entities.vo.SemesterVo;

/**
 * 学期表映射操作
 */
public interface ISemesterMapper {

    /**
     * 新增学期信息
     * @param semesterVo 学期信息
     * @return 成功新增学期信息数据条数
     */
    public int insert(SemesterVo semesterVo);

    /**
     * 根据学期信息ID
     * @param id 学期信息ID
     * @return 学期信息
     */
    public SemesterVo selectById(String id);

    /**
     * 根据学期信息ID，关联所属学校信息
     * @param id 学期信息ID
     * @return 学期信息
     */
    public SemesterVo selectWithSchoolById(String id);
}
