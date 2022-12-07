package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: ShortAnswerQuestionEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:40
 * @Version 1.0
 */
@Entity
@Table(name = "short_answer_question", schema = "LearnJava", catalog = "")
public class ShortAnswerQuestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "short_answer_question_id")
    private int shortAnswerQuestionId;
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

    public int getShortAnswerQuestionId() {
        return shortAnswerQuestionId;
    }

    public void setShortAnswerQuestionId(int shortAnswerQuestionId) {
        this.shortAnswerQuestionId = shortAnswerQuestionId;
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
        ShortAnswerQuestionEntity that = (ShortAnswerQuestionEntity) o;
        return shortAnswerQuestionId == that.shortAnswerQuestionId && corrLessonId == that.corrLessonId && corrKnowledgeId == that.corrKnowledgeId && Objects.equals(corrChapterId, that.corrChapterId) && Objects.equals(questionContent, that.questionContent) && Objects.equals(referenceAnswer, that.referenceAnswer) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortAnswerQuestionId, corrLessonId, corrKnowledgeId, corrChapterId, questionContent, referenceAnswer, score);
    }
}