package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import org.springframework.stereotype.Service;

/**
 * @title: QuestionService
 * @Author Xinyu Fang
 * @Date: 2022/12/6 10:42
 * @Version 1.0
 */
@Service
public interface QuestionService {
    /**
     * 获取问题列表
     * @param corrKnowledgeId 知识点id
     * @param userId 用户id
     * @return 返回问题列表
     */
    JsonResultEntity getRelatedQuestion(int corrKnowledgeId,int userId);



}
