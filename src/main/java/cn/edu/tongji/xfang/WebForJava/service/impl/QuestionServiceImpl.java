package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.*;
import cn.edu.tongji.xfang.WebForJava.models.ChoiceQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.ShortAnswerQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: QuestionServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/6 15:30
 * @Version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    ChoiceQuestionEntityRepository choiceQuestionEntityRepository;

    @Resource
    ShortAnswerQuestionEntityRepository shortAnswerQuestionEntityRepository;

    @Resource
    KnowledgeEntityRepository knowledgeEntityRepository;

    @Resource
    AnswerSituationEntityRepository answerSituationEntityRepository;

    @Resource
    ChaptersEntityRepository chaptersEntityRepository;

    @Resource
    LessonsEntityRepository lessonsEntityRepository;

    @Override
    public JsonResultEntity getRelatedQuestion(int corrKnowledgeId,int userId) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            List<ChoiceQuestionEntity> alreadyAnsweredchoiceQuestionEntityList = choiceQuestionEntityRepository.findChoiceQuestionEntitiesByAnswerSituation(corrKnowledgeId,userId,"choice_question");
            List<Integer> alreadyAnsweredchoiceQuestionIdList = new ArrayList<>();
            for(ChoiceQuestionEntity choiceQuestionEntity:alreadyAnsweredchoiceQuestionEntityList){
                alreadyAnsweredchoiceQuestionIdList.add(choiceQuestionEntity.getChoiceQuestionId());
            }

            List<ShortAnswerQuestionEntity> alreadyAnswerSAQList = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntitiesByAnswerSituation(corrKnowledgeId,userId,"short_answer_question");
            List<Integer> alreadyAnswerSAQIdList = new ArrayList<>();
            for(ShortAnswerQuestionEntity saq:alreadyAnswerSAQList){
                alreadyAnswerSAQIdList.add(saq.getShortAnswerQuestionId());
            }

            List<ChoiceQuestionEntity> choiceQuestionEntityList = choiceQuestionEntityRepository.findChoiceQuestionEntitiesByCorrKnowledgeId(corrKnowledgeId);
            List<Map<String, Object>> CQList = new ArrayList<>();
            for(ChoiceQuestionEntity choiceQuestionEntity:choiceQuestionEntityList){
                if(alreadyAnsweredchoiceQuestionIdList.contains(choiceQuestionEntity.getChoiceQuestionId())){
                    Map<String, Object> AnsweredCQ = new HashMap<>();
                    AnsweredCQ.put("detail",choiceQuestionEntity);
                    AnsweredCQ.put("haveBeenAnswered",true);
                    CQList.add(AnsweredCQ);
                }
                else{
                    Map<String, Object> NotAnsweredCQ = new HashMap<>();
                    NotAnsweredCQ.put("detail",choiceQuestionEntity);
                    NotAnsweredCQ.put("haveBeenAnswered",false);
                    CQList.add(NotAnsweredCQ);
                }
            }
            message.data.put("choiceAnswerList",CQList);

            List<ShortAnswerQuestionEntity> shortAnswerQuestionEntityList = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntitiesByCorrKnowledgeId(corrKnowledgeId);
            List<Map<String, Object>> SAQList = new ArrayList<>();
            for(ShortAnswerQuestionEntity shortAnswerQuestionEntity:shortAnswerQuestionEntityList){
                if(alreadyAnswerSAQIdList.contains(shortAnswerQuestionEntity.getShortAnswerQuestionId())){
                    Map<String, Object> AnsweredSAQ = new HashMap<>();
                    AnsweredSAQ.put("detail",shortAnswerQuestionEntity);
                    AnsweredSAQ.put("haveBeenAnswered",true);
                    SAQList.add(AnsweredSAQ);
                }
                else{
                    Map<String, Object> NotAnsweredSAQ = new HashMap<>();
                    NotAnsweredSAQ.put("detail",shortAnswerQuestionEntity);
                    NotAnsweredSAQ.put("haveBeenAnswered",false);
                    SAQList.add(NotAnsweredSAQ);
                }
            }
            message.data.put("shortAnswerQuestionList",SAQList);
            message.errorCode = 200;
            message.status = true;

        } catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "题目获取错误");
        }
        return message;
    }
    @Override
    public JsonResultEntity getRelatedQuestionByChapter(int corrChapterId,int userId){
        JsonResultEntity message = new JsonResultEntity();
        try {
            List<ChoiceQuestionEntity> alreadyAnsweredchoiceQuestionEntityList = choiceQuestionEntityRepository.findChoiceQuestionEntitiesByChapter(corrChapterId,userId,"choice_question");
            List<Integer> alreadyAnsweredchoiceQuestionIdList = new ArrayList<>();
            for(ChoiceQuestionEntity choiceQuestionEntity:alreadyAnsweredchoiceQuestionEntityList){
                alreadyAnsweredchoiceQuestionIdList.add(choiceQuestionEntity.getChoiceQuestionId());
            }

            List<ShortAnswerQuestionEntity> alreadyAnswerSAQList = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntitiesByChapter(corrChapterId,userId,"short_answer_question");
            List<Integer> alreadyAnswerSAQIdList = new ArrayList<>();
            for(ShortAnswerQuestionEntity saq:alreadyAnswerSAQList){
                alreadyAnswerSAQIdList.add(saq.getShortAnswerQuestionId());
            }

            List<ChoiceQuestionEntity> choiceQuestionEntityList = choiceQuestionEntityRepository.findChoiceQuestionEntitiesByCorrChapterId(corrChapterId);
            List<Map<String, Object>> CQList = new ArrayList<>();
            for(ChoiceQuestionEntity choiceQuestionEntity:choiceQuestionEntityList){
                if(alreadyAnsweredchoiceQuestionIdList.contains(choiceQuestionEntity.getChoiceQuestionId())){
                    Map<String, Object> AnsweredCQ = new HashMap<>();
                    AnsweredCQ.put("detail",choiceQuestionEntity);
                    AnsweredCQ.put("haveBeenAnswered",true);
                    AnsweredCQ.put("thisUserAnswer",answerSituationEntityRepository.findUserAnswerByQuestionIdAndUserId("choice_question",choiceQuestionEntity.getChoiceQuestionId(),userId));
                    CQList.add(AnsweredCQ);
                }
                else{
                    Map<String, Object> NotAnsweredCQ = new HashMap<>();
                    NotAnsweredCQ.put("detail",choiceQuestionEntity);
                    NotAnsweredCQ.put("haveBeenAnswered",false);
                    CQList.add(NotAnsweredCQ);
                }
            }
            message.data.put("choiceAnswerList",CQList);

            List<ShortAnswerQuestionEntity> shortAnswerQuestionEntityList = shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntitiesByCorrChapterId(corrChapterId);
            List<Map<String, Object>> SAQList = new ArrayList<>();
            for(ShortAnswerQuestionEntity shortAnswerQuestionEntity:shortAnswerQuestionEntityList){
                if(alreadyAnswerSAQIdList.contains(shortAnswerQuestionEntity.getShortAnswerQuestionId())){
                    Map<String, Object> AnsweredSAQ = new HashMap<>();
                    AnsweredSAQ.put("detail",shortAnswerQuestionEntity);
                    AnsweredSAQ.put("haveBeenAnswered",true);
                    AnsweredSAQ.put("thisUserAnswer",answerSituationEntityRepository.findUserAnswerByQuestionIdAndUserId("short_answer_question",shortAnswerQuestionEntity.getShortAnswerQuestionId(),userId));
                    SAQList.add(AnsweredSAQ);
                }
                else{
                    Map<String, Object> NotAnsweredSAQ = new HashMap<>();
                    NotAnsweredSAQ.put("detail",shortAnswerQuestionEntity);
                    NotAnsweredSAQ.put("haveBeenAnswered",false);
                    SAQList.add(NotAnsweredSAQ);
                }
            }
            message.data.put("shortAnswerQuestionList",SAQList);
            message.errorCode = 200;
            message.status = true;

        } catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "题目获取错误");
        }
        return message;

    }

    @Override
    public JsonResultEntity getUserChapterQuestionInfoByLesson(int corrLessonId,int userId) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            List<Map<String,Object>> chapterQuestionList  = new ArrayList<>();
            List<Integer> chapterIdList = chaptersEntityRepository.findAllChapterIdByLessonId(corrLessonId);
            for(Integer chapterid:chapterIdList){
                Map<String,Object> temp = new HashMap();
                temp.put("lesson_name",lessonsEntityRepository.findLessonTitleByLessonId(corrLessonId));
                temp.put("chapter_id",chapterid);
                temp.put("chapter_name",chaptersEntityRepository.findChapterNameByChapterId(chapterid));
                temp.put("total_question_num",choiceQuestionEntityRepository.findQueNumByCorrChapterId(chapterid)+shortAnswerQuestionEntityRepository.findQueNumByCorrChapterId(chapterid));
                temp.put("already_done_question_num",shortAnswerQuestionEntityRepository.findShortAnswerQuestionEntitiesByChapter(chapterid,userId,"short_answer_question").size()+choiceQuestionEntityRepository.findChoiceQuestionEntitiesByChapter(chapterid,userId,"choice_question").size());
                temp.put("not_done_question_num",(Integer)temp.get("total_question_num")-(Integer)temp.get("already_done_question_num"));
                temp.put("finish_rate",((Integer)temp.get("already_done_question_num")*100/(Integer)temp.get("total_question_num")));
                chapterQuestionList.add(temp);
            }

            message.data.put("data",chapterQuestionList);
            message.errorCode = 200;
            message.status = true;
        }catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "题目信息获取错误");
        }
        return message;
    }

    @Override
    public JsonResultEntity answerQuestion(String questionType,int questionId,int UserId,String answer) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            int isSuccess = answerSituationEntityRepository.userAnswerQuestion(questionType, questionId, UserId, answer);
            message.errorCode = 200;
            message.status = true;
            message.data.put("symbol", true);
        } catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "该题已被回答过！");
        }
        return message;
    }


}