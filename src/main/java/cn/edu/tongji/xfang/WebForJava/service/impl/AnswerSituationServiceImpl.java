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
            for(AnswerSituationEntity AS:ASList){
                Map<String, Object> temp = new HashMap();
                temp.put("question_id",AS.getQuestionId());
                int questionId = AS.getQuestionId();
                temp.put("question_type",AS.getQuestionType());
                temp.put("user_answer",AS.getUserAnswer());
                temp.put("answer_time",AS.getAnswerTime());
                try{
                    if(temp.get("question_type").equals("choice_question") ) {
                        ChoiceQuestionEntity CQE = choiceQuestionEntityRepository.findChoiceQuestionEntityByChoiceQuestionId(questionId);
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
                temp.put("lesson_name",lessonsEntityRepository.findByLessonId((Integer) temp.get("lesson_id")).getLessonTitle());
                temp.put("chapter_name",chaptersEntityRepository.findChapterByChapterId((Integer) temp.get("chapter_id")).getChapterTitle());
                try {
                    temp.put("score",judgeInfoEntityRepository.findScoreByAnswerSituationId(AS.getId()));
                }catch (Exception e){
                    temp.put("score","未批改");
                }

                returnASList.add(temp);
            }

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

    public JsonResultEntity findAllAnswerRecord(){
        JsonResultEntity message = new JsonResultEntity();
        try{
            List<AnswerSituationEntity> JudgedList = answerSituationEntityRepository.findAllJudgedAnswerRecord();
            List<AnswerSituationEntity> UnJudgedList = answerSituationEntityRepository.findAllUnJudgedAnswerRecord();
            List<Map<String,Object>> returnJudgedList  = new ArrayList<>();
            List<Map<String,Object>> returnUnJudgedList  = new ArrayList<>();
            for(AnswerSituationEntity UnjudgedAS:UnJudgedList){
                Map<String,Object> returnMap = new HashMap<>();
                int question_id = UnjudgedAS.getQuestionId();
                String question_type = UnjudgedAS.getQuestionType();
                if(question_type.equals("choice_question")){
                    ChoiceQuestionEntity CQE = choiceQuestionEntityRepository.findChoiceQuestionEntityByChoiceQuestionId(question_id);

                    returnMap.put("lesson_id",CQE.getCorrLessonId());
                    returnMap.put("lesson_title",lessonsEntityRepository.findByLessonId(CQE.getCorrLessonId()).getLessonTitle());
                    returnMap.put("chapter_id",CQE.getCorrChapterId());
                    returnMap.put("chapter_title",chaptersEntityRepository.findChapterByChapterId(CQE.getCorrChapterId()).getChapterTitle());
                    returnMap.put("question_content",CQE.getQuestionContent());
                    returnMap.put("reference_answer",CQE.getQuestionAnswer());
                    returnMap.put("score_for_this_question",CQE.getScore());

                }
                else if(question_type.equals("short_answer_question")){
                    ShortAnswerQuestionEntity SAQE = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntityByShortAnswerQuestionId(question_id);

                    returnMap.put("lesson_id",SAQE.getCorrLessonId());
                    returnMap.put("lesson_title",lessonsEntityRepository.findByLessonId(SAQE.getCorrLessonId()).getLessonTitle());
                    returnMap.put("chapter_id",SAQE.getCorrChapterId());
                    returnMap.put("chapter_title",chaptersEntityRepository.findChapterByChapterId(SAQE.getCorrChapterId()).getChapterTitle());
                    returnMap.put("question_content",SAQE.getQuestionContent());
                    returnMap.put("reference_answer",SAQE.getReferenceAnswer());
                    returnMap.put("score_for_this_question",SAQE.getScore());
                }
                returnMap.put("user_answer",UnjudgedAS.getUserAnswer());
                returnMap.put("user_id",UnjudgedAS.getUserId());
                returnMap.put("answer_time",UnjudgedAS.getAnswerTime());
                returnMap.put("answer_situation_id",UnjudgedAS.getId());
                try {
                    returnMap.put("score",judgeInfoEntityRepository.findScoreByAnswerSituationId(UnjudgedAS.getId()));
                }catch (Exception e){
                    returnMap.put("score","未批改");
                }
                returnUnJudgedList.add(returnMap);
            }
            for(AnswerSituationEntity JudgedAS:JudgedList) {
                Map<String, Object> returnMap = new HashMap<>();
                int question_id = JudgedAS.getQuestionId();
                String question_type = JudgedAS.getQuestionType();
                if (question_type.equals("choice_question")) {
                    ChoiceQuestionEntity CQE = choiceQuestionEntityRepository.findChoiceQuestionEntityByChoiceQuestionId(question_id);

                    returnMap.put("lesson_id", CQE.getCorrLessonId());
                    returnMap.put("lesson_title", lessonsEntityRepository.findByLessonId(CQE.getCorrLessonId()).getLessonTitle());
                    returnMap.put("chapter_id", CQE.getCorrChapterId());
                    returnMap.put("chapter_title", chaptersEntityRepository.findChapterByChapterId(CQE.getCorrChapterId()).getChapterTitle());
                    returnMap.put("question_content", CQE.getQuestionContent());
                    returnMap.put("reference_answer", CQE.getQuestionAnswer());
                    returnMap.put("score_for_this_question", CQE.getScore());

                } else if (question_type.equals("short_answer_question")) {
                    ShortAnswerQuestionEntity SAQE = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntityByShortAnswerQuestionId(question_id);

                    returnMap.put("lesson_id", SAQE.getCorrLessonId());
                    returnMap.put("lesson_title", lessonsEntityRepository.findByLessonId(SAQE.getCorrLessonId()).getLessonTitle());
                    returnMap.put("chapter_id", SAQE.getCorrChapterId());
                    returnMap.put("chapter_title", chaptersEntityRepository.findChapterByChapterId(SAQE.getCorrChapterId()).getChapterTitle());
                    returnMap.put("question_content", SAQE.getQuestionContent());
                    returnMap.put("reference_answer", SAQE.getReferenceAnswer());
                    returnMap.put("score_for_this_question", SAQE.getScore());
                }
                returnMap.put("user_answer", JudgedAS.getUserAnswer());
                returnMap.put("user_id", JudgedAS.getUserId());
                returnMap.put("answer_time", JudgedAS.getAnswerTime());
                returnMap.put("answer_situation_id", JudgedAS.getId());
                try {
                    returnMap.put("score", judgeInfoEntityRepository.findScoreByAnswerSituationId(JudgedAS.getId()));
                } catch (Exception e) {
                    returnMap.put("score", "未批改");
                }
                returnJudgedList.add(returnMap);
            }
            message.data.put("JudgedList",returnJudgedList);
            message.data.put("UnJudgedList",returnUnJudgedList);
            message.errorCode = 200;
            message.status = true;
        }catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }

}