package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: LessonsEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:40
 * @Version 1.0
 */
@Entity
@Table(name = "lessons", schema = "LearnJava", catalog = "")
public class LessonsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lesson_id")
    private int lessonId;
    @Basic
    @Column(name = "lesson_title")
    private String lessonTitle;
    @Basic
    @Column(name = "lesson_content")
    private String lessonContent;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonsEntity that = (LessonsEntity) o;
        return lessonId == that.lessonId && Objects.equals(lessonTitle, that.lessonTitle) && Objects.equals(lessonContent, that.lessonContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, lessonTitle, lessonContent);
    }
}