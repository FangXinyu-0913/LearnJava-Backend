package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: TeacherInfoEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:40
 * @Version 1.0
 */
@Entity
@Table(name = "teacher_info", schema = "LearnJava", catalog = "")
public class TeacherInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "teacher_name")
    private String teacherName;
    @Basic
    @Column(name = "teacher_password")
    private String teacherPassword;
    @Basic
    @Column(name = "teacher_id")
    private String teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherInfoEntity that = (TeacherInfoEntity) o;
        return id == that.id && Objects.equals(teacherName, that.teacherName) && Objects.equals(teacherPassword, that.teacherPassword) && Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherName, teacherPassword, teacherId);
    }
}