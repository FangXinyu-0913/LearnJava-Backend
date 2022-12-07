package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: ChooseLessonEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 9:05
 * @Version 1.0
 */
@Entity
@Table(name = "choose_lesson", schema = "LearnJava", catalog = "")
@IdClass(ChooseLessonEntityPK.class)
public class ChooseLessonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lesson_id")
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
        ChooseLessonEntity that = (ChooseLessonEntity) o;
        return studentId == that.studentId && lessonId == that.lessonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, lessonId);
    }
}