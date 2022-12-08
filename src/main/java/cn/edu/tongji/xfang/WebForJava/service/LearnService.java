package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import org.springframework.stereotype.Service;
/**
 * @title: LearnService
 * @Author Xinyu Fang
 * @Date: 2022/12/6 9:39
 * @Version 1.0
 */
@Service
public interface LearnService {
    JsonResultEntity userLearnKnowledge(int userId, int knowledgeId, int lessonId,int chapterId);

    JsonResultEntity getLearnKnowledgeRecordByLessonAndUser(int userId, int lessonId);
}
