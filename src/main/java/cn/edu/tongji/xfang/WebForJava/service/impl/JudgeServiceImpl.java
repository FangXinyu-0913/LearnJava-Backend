package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.AnswerSituationEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.JudgeInfoEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.JudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @title: JudgeServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/9 20:05
 * @Version 1.0
 */
@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    JudgeInfoEntityRepository judgeInfoEntityRepository;
    @Resource
    AnswerSituationEntityRepository answerSituationEntityRepository;
    @Override
    public JsonResultEntity JudgeAnswerSituation(int answerSituationId, int teacherId, int score) {
        JsonResultEntity message = new JsonResultEntity();
        try{
            int symbol = judgeInfoEntityRepository.judgeAnswer(teacherId, score, answerSituationId) + answerSituationEntityRepository.updateTeacherId(teacherId, answerSituationId);
            message.errorCode = 200;
            message.status = true;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }

}