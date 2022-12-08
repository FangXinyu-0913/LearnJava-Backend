package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @title: AnswerSituationEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:39
 * @Version 1.0
 */
@Entity
@Table(name = "answer_situation", schema = "LearnJava", catalog = "")
public class AnswerSituationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "answer_time")
    private Timestamp answerTime;
    @Basic
    @Column(name = "question_type")
    private String questionType;
    @Basic
    @Column(name = "question_id")
    private int questionId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic
    @Column(name = "user_answer")
    private String userAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerSituationEntity that = (AnswerSituationEntity) o;
        return id == that.id && questionId == that.questionId && userId == that.userId && teacherId == that.teacherId && Objects.equals(answerTime, that.answerTime) && Objects.equals(questionType, that.questionType) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerTime, questionType, questionId, userId, teacherId);
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}