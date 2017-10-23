package com.github.seedm.repository.entities.vo.seed;

/**
 * 学期学生关系表映射VO
 * @author Eugene
 */
public class SemesterStudentVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 学期ID
     */
    private String semesterId;

    /**
     * 学生ID
     */
    private String studentId;

    public SemesterStudentVo() {
    }

    public SemesterStudentVo(String id, String semesterId, String studentId) {
        this.id = id;
        this.semesterId = semesterId;
        this.studentId = studentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
