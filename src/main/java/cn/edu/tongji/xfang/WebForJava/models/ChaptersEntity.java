package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: ChaptersEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:39
 * @Version 1.0
 */
@Entity
@Table(name = "chapters", schema = "LearnJava", catalog = "")
public class ChaptersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chapter_id")
    private int chapterId;
    @Basic
    @Column(name = "corr_lesson_id")
    private int corrLessonId;
    @Basic
    @Column(name = "chapter_title")
    private String chapterTitle;
    @Basic
    @Column(name = "chapter_content")
    private String chapterContent;

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getCorrLessonId() {
        return corrLessonId;
    }

    public void setCorrLessonId(int corrLessonId) {
        this.corrLessonId = corrLessonId;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChaptersEntity that = (ChaptersEntity) o;
        return chapterId == that.chapterId && corrLessonId == that.corrLessonId && Objects.equals(chapterTitle, that.chapterTitle) && Objects.equals(chapterContent, that.chapterContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterId, corrLessonId, chapterTitle, chapterContent);
    }
}