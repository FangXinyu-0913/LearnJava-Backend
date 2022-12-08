package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.*;
import cn.edu.tongji.xfang.WebForJava.models.AnswerSituationEntity;
import cn.edu.tongji.xfang.WebForJava.models.ChoiceQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.ShortAnswerQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.service.AnswerSituationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @title: AnswerSituationServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/8 9:30
 * @Version 1.0
 */
@Service
public class AnswerSituationServiceImpl implements AnswerSituationService {

    @Resource
    AnswerSituationEntityRepository answerSituationEntityRepository;
    @Resource
    ChoiceQuestionEntityRepository choiceQuestionEntityRepository;
    @Resource
    ShortAnswerQuestionEntityRepository shortAnswerQuestionEntityRepository;
    @Resource
    LessonsEntityRepository lessonsEntityRepository;
    @Resource
    ChaptersEntityRepository chaptersEntityRepository;
    @Resource
    JudgeInfoEntityRepository judgeInfoEntityRepository;
    @Override
    public String findUserAnswerByQuestionIdAndUserId(String questionType, int questionId, int userId) {
        return null;
    }

    @Override
    public int userAnswerQuestion(String questionType, int questionId, int userId, String answer) {
        return 0;
    }

    @Override
    public JsonResultEntity findAllRecordsByUserId(int userId){
        JsonResultEntity message = new JsonResultEntity();
        try{
            List<Map<String,Object>> returnASList  = new ArrayList<>();
            List<AnswerSituationEntity> ASList = answerSituationEntityRepository.findAllAnswerRecordByUserId(userId);
            System.out.println(ASList.size());
            for(AnswerSituationEntity AS:ASList){
                Map<String, Object> temp = new HashMap();
                temp.put("question_id",AS.getQuestionId());
                int questionId = AS.getQuestionId();
                System.out.println("questionId"+ questionId);
                temp.put("question_type",AS.getQuestionType());
                temp.put("user_answer",AS.getUserAnswer());
                temp.put("answer_time",AS.getAnswerTime());
                System.out.println(AS.getQuestionType());
                System.out.println(AS.getQuestionId());
                try{
                    if(temp.get("question_type").equals("choice_question") ) {
                        System.out.println("choice_question");
                        ChoiceQuestionEntity CQE = choiceQuestionEntityRepository.findChoiceQuestionEntityByChoiceQuestionId(questionId);
                        System.out.println("success?");
                        temp.put("question_content",CQE.getQuestionContent());
                        temp.put("lesson_id",CQE.getCorrLessonId());
                        temp.put("chapter_id",CQE.getCorrChapterId());
                    }
                    else if(temp.get("question_type").equals("short_answer_question")){
                        ShortAnswerQuestionEntity SAQE = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntityByShortAnswerQuestionId(questionId);
                        temp.put("question_content",SAQE.getQuestionContent());
                        temp.put("lesson_id",SAQE.getCorrLessonId());
                        temp.put("chapter_id",SAQE.getCorrChapterId());
                    }
                }catch (Exception e){
                    System.out.println("inter11");
                    message.data.put("error1", e.getMessage());
                }
                System.out.println("inter2");
                temp.put("lesson_name",lessonsEntityRepository.findByLessonId((Integer) temp.get("lesson_id")).getLessonTitle());
                temp.put("chapter_name",chaptersEntityRepository.findChapterByChapterId((Integer) temp.get("chapter_id")).getChapterTitle());
                try {
                    temp.put("score",judgeInfoEntityRepository.findScoreByAnswerSituationId(AS.getId()));
                }catch (Exception e){
                    temp.put("score","未批改");
                }
                System.out.println("final");
                System.out.println(temp);
                returnASList.add(temp);
            }
            System.out.println(returnASList);
            message.data.put("data", returnASList);
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