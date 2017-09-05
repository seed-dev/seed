package com.github.seedm.repository.vo.seed;

/**
 * 学生学校关系表映射VO
 */
public class StudentSchoolVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 学生ID
     */
    private String studentId;

    /**
     * 学校ID
     */
    private String schoolId;

    public StudentSchoolVo() {
    }

    public StudentSchoolVo(String id, String studentId, String schoolId) {
        this.id = id;
        this.studentId = studentId;
        this.schoolId = schoolId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
