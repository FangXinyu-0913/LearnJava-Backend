package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @title: JudgeInfoEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:40
 * @Version 1.0
 */
@Entity
@Table(name = "judge_info", schema = "LearnJava", catalog = "")
public class JudgeInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "judge_id")
    private int judgeId;
    @Basic
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic
    @Column(name = "score")
    private Integer score;
    @Basic
    @Column(name = "answer_situation_id")
    private Integer answerSituationId;
    @Basic
    @Column(name = "judge_time")
    private Timestamp judgeTime;

    public int getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAnswerSituationId() {
        return answerSituationId;
    }

    public void setAnswerSituationId(Integer answerSituationId) {
        this.answerSituationId = answerSituationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JudgeInfoEntity that = (JudgeInfoEntity) o;
        return judgeId == that.judgeId && teacherId == that.teacherId && Objects.equals(score, that.score) && Objects.equals(answerSituationId, that.answerSituationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(judgeId, teacherId, score, answerSituationId);
    }

    public Timestamp getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(Timestamp judgeTime) {
        this.judgeTime = judgeTime;
    }
}