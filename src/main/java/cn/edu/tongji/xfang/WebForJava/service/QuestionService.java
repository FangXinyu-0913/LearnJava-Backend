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

    /**
     * 根据章节获取问题列表
     * @param corrChapterId 章节id
     * @param userId 用户id
     * @return 返回问题列表
     */
    JsonResultEntity getRelatedQuestionByChapter(int corrChapterId,int userId);

    JsonResultEntity getUserChapterQuestionInfoByLesson(int corrLessonId,int userId);

    JsonResultEntity answerQuestion(String questionType,int questionId,int UserId,String answer);

    JsonResultEntity addShortAnswerQuestion(int lesson_id,int chapter_id,String question_content,String reference_answer,int score);

    JsonResultEntity addChoiceQuestion(int lesson_id,int chapter_id,String question_content,String reference_answer, int score,String choice_A,String choice_B,String choice_C,String choice_D);


}
