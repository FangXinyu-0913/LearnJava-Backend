package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: StudentInfoEntity
 * @Author Tan
 * @Date: 2022/12/3 13:54
 * @Version 1.0
 */
@Entity
@Table(name = "student_info", schema = "LearnJava", catalog = "")
public class StudentInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "student_name")
    private String studentName;
    @Basic
    @Column(name = "student_password")
    private String studentPassword;
    @Basic
    @Column(name = "student_id")
    private String studentId;
    @Basic
    @Column(name = "current_steps")
    private int currentSteps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getCurrentSteps() {
        return currentSteps;
    }

    public void setCurrentSteps(int currentSteps) {
        this.currentSteps = currentSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        StudentInfoEntity that = (StudentInfoEntity) o;
        return id == that.id && currentSteps == that.currentSteps && Objects.equals(studentName, that.studentName) && Objects.equals(studentPassword, that.studentPassword) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, studentPassword, studentId, currentSteps);
    }
}