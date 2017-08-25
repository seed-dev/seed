package com.github.seedm.repository.mapper.seed;

import com.github.seedm.repository.vo.SchoolVO;

import java.util.List;

/**
 * 学校表映射操作定义
 * @author Eugene
 */
public interface ISchoolMapper {

    /**
     * 新增学校
     * @param schoolVO 学校信息
     * @return 成功新增学校信息条数
     */
    public int insertSchool(SchoolVO schoolVO);

    /**
     * 删除指定ID的学校信息
     * @param id 学校ID
     * @return 成功删除学校信息条数
     */
    public int deleteSchoolById(String id);

    /**
     * 更新学校信息
     * @param schoolVO 学校信息
     * @return 成功更新学校信息的条数
     */
    public int update(SchoolVO schoolVO);

    /**
     * 查询全部学校信息
     * @return 学校信息列表
     */
    public List<SchoolVO> selectAll();


}
