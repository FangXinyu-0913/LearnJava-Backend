package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import org.springframework.stereotype.Service;

/**
 * @author Xinyu Fang
 */
@Service
public interface JudgeService {
    /**
     * 老师对学生作答记录进行批改
     * @param answerSituationId 作答记录id
     * @param teacherId 老师id
     * @param score 分数
     * @return 返回是否正确
     */
    JsonResultEntity JudgeAnswerSituation(int answerSituationId, int teacherId, int score);
}
