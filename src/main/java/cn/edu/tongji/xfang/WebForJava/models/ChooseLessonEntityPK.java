package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @title: ChooseLessonEntityPK
 * @Author Xinyu Fang
 * @Date: 2022/12/6 9:05
 * @Version 1.0
 */
public class ChooseLessonEntityPK implements Serializable {
    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name = "lesson_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChooseLessonEntityPK that = (ChooseLessonEntityPK) o;
        return studentId == that.studentId && lessonId == that.lessonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, lessonId);
    }
}