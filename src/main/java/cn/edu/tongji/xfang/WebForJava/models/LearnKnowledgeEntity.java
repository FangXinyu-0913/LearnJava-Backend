package cn.edu.tongji.xfang.WebForJava.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @title: LearnKnowledgeEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/6 8:40
 * @Version 1.0
 */
@Entity
@Table(name = "learn_knowledge", schema = "LearnJava", catalog = "")
public class LearnKnowledgeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "record_id")
    private int recordId;
    @Basic
    @Column(name = "knowledge_id")
    private Integer knowledgeId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "learn_time")
    private Timestamp learnTime;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(Timestamp learnTime) {
        this.learnTime = learnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearnKnowledgeEntity that = (LearnKnowledgeEntity) o;
        return recordId == that.recordId && Objects.equals(knowledgeId, that.knowledgeId) && Objects.equals(userId, that.userId) && Objects.equals(learnTime, that.learnTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, knowledgeId, userId, learnTime);
    }
}