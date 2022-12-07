package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * @title: ChoiceQuestionEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 14:57
 * @Version 1.0
 */
@Entity
@Table(name = "choice_question", schema = "LearnJava", catalog = "")
public class ChoiceQuestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "choice_question_id")
    private int choiceQuestionId;
    @Basic
    @Column(name = "corr_lesson_id")
    private Integer corrLessonId;
    @Basic
    @Column(name = "corr_knowledge_id")
    private Integer corrKnowledgeId;
    @Basic
    @Column(name = "question_content")
    private String questionContent;
    @Basic
    @Column(name = "question_answer")
    private String questionAnswer;
    @Basic
    @Column(name = "choice_A")
    private String choiceA;
    @Basic
    @Column(name = "choice_B")
    private String choiceB;
    @Basic
    @Column(name = "choice_C")
    private String choiceC;
    @Basic
    @Column(name = "choice_D")
    private String choiceD;
    @Basic
    @Column(name = "score")
    private Integer score;
    @Basic
    @Column(name = "corr_chapter_id")
    private Integer corrChapterId;

    public int getChoiceQuestionId() {
        return choiceQuestionId;
    }

    public void setChoiceQuestionId(int choiceQuestionId) {
        this.choiceQuestionId = choiceQuestionId;
    }

    public Integer getCorrLessonId() {
        return corrLessonId;
    }

    public void setCorrLessonId(Integer corrLessonId) {
        this.corrLessonId = corrLessonId;
    }

    public Integer getCorrKnowledgeId() {
        return corrKnowledgeId;
    }

    public void setCorrKnowledgeId(Integer corrKnowledgeId) {
        this.corrKnowledgeId = corrKnowledgeId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCorrChapterId() {
        return corrChapterId;
    }

    public void setCorrChapterId(Integer corrChapterId) {
        this.corrChapterId = corrChapterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChoiceQuestionEntity that = (ChoiceQuestionEntity) o;
        return choiceQuestionId == that.choiceQuestionId && Objects.equals(corrLessonId, that.corrLessonId) && Objects.equals(corrKnowledgeId, that.corrKnowledgeId) && Objects.equals(questionContent, that.questionContent) && Objects.equals(questionAnswer, that.questionAnswer) && Objects.equals(choiceA, that.choiceA) && Objects.equals(choiceB, that.choiceB) && Objects.equals(choiceC, that.choiceC) && Objects.equals(choiceD, that.choiceD) && Objects.equals(score, that.score) && Objects.equals(corrChapterId, that.corrChapterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(choiceQuestionId, corrLessonId, corrKnowledgeId, questionContent, questionAnswer, choiceA, choiceB, choiceC, choiceD, score, corrChapterId);
    }
}