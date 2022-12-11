package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: QuestionEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/11 21:43
 * @Version 1.0
 */
@Entity
@Table(name = "question", schema = "LearnJava", catalog = "")
public class QuestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "corr_lesson_id")
    private int corrLessonId;
    @Basic
    @Column(name = "corr_knowledge_id")
    private int corrKnowledgeId;
    @Basic
    @Column(name = "corr_chapter_id")
    private Integer corrChapterId;
    @Basic
    @Column(name = "question_content")
    private String questionContent;
    @Basic
    @Column(name = "reference_answer")
    private String referenceAnswer;
    @Basic
    @Column(name = "score")
    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrLessonId() {
        return corrLessonId;
    }

    public void setCorrLessonId(int corrLessonId) {
        this.corrLessonId = corrLessonId;
    }

    public int getCorrKnowledgeId() {
        return corrKnowledgeId;
    }

    public void setCorrKnowledgeId(int corrKnowledgeId) {
        this.corrKnowledgeId = corrKnowledgeId;
    }

    public Integer getCorrChapterId() {
        return corrChapterId;
    }

    public void setCorrChapterId(Integer corrChapterId) {
        this.corrChapterId = corrChapterId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getReferenceAnswer() {
        return referenceAnswer;
    }

    public void setReferenceAnswer(String referenceAnswer) {
        this.referenceAnswer = referenceAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return id == that.id && corrLessonId == that.corrLessonId && corrKnowledgeId == that.corrKnowledgeId && Objects.equals(corrChapterId, that.corrChapterId) && Objects.equals(questionContent, that.questionContent) && Objects.equals(referenceAnswer, that.referenceAnswer) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, corrLessonId, corrKnowledgeId, corrChapterId, questionContent, referenceAnswer, score);
    }
}