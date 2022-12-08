package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;

public interface AnswerSituationService {
    /**
     * 根据问题id和用户id获取用户答案
     * @param questionType 问题类型
     * @param questionId 问题id
     * @param userId 用户id
     * @return 返回用户答案
     */
    String findUserAnswerByQuestionIdAndUserId(String questionType,int questionId,int userId);

    /**
     * 用户回答问题
     * @param questionType 问题类型
     * @param questionId 问题id
     * @param userId 用户id
     * @param answer 用户答案
     * @return 返回是否成功
     */
    int userAnswerQuestion(String questionType,int questionId,int userId,String answer);

    /**
     * 获取用户所有答题记录
     * @param userId 用户id
     * @return 返回用户所有答题记录
     */
    JsonResultEntity findAllRecordsByUserId(int userId);

}
