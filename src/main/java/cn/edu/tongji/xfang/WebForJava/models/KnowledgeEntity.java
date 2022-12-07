package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: KnowledgeEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:40
 * @Version 1.0
 */
@Entity
@Table(name = "knowledge", schema = "LearnJava", catalog = "")
public class KnowledgeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "knowledge_id")
    private int knowledgeId;
    @Basic
    @Column(name = "knowledge_content")
    private String knowledgeContent;
    @Basic
    @Column(name = "corr_chapter_id")
    private int corrChapterId;
    @Basic
    @Column(name = "corr_lesson_id")
    private int corrLessonId;

    public int getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(int knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeContent() {
        return knowledgeContent;
    }

    public void setKnowledgeContent(String knowledgeContent) {
        this.knowledgeContent = knowledgeContent;
    }

    public int getCorrChapterId() {
        return corrChapterId;
    }

    public void setCorrChapterId(int corrChapterId) {
        this.corrChapterId = corrChapterId;
    }

    public int getCorrLessonId() {
        return corrLessonId;
    }

    public void setCorrLessonId(int corrLessonId) {
        this.corrLessonId = corrLessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnowledgeEntity that = (KnowledgeEntity) o;
        return knowledgeId == that.knowledgeId && corrChapterId == that.corrChapterId && corrLessonId == that.corrLessonId && Objects.equals(knowledgeContent, that.knowledgeContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(knowledgeId, knowledgeContent, corrChapterId, corrLessonId);
    }
}