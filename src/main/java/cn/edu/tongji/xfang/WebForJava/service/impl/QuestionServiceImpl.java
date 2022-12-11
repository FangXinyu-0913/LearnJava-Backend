package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.*;
import cn.edu.tongji.xfang.WebForJava.models.ChoiceQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.ShortAnswerQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    LearnKnowledgeEntityRepository learnKnowledgeEntityRepository;

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
                if((Integer)temp.get("total_question_num") == 0){
                    temp.put("finish_rate",0);
                }
                else{
                    temp.put("finish_rate",((Integer)temp.get("already_done_question_num")*100/(Integer)temp.get("total_question_num")));
                }
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

    @Override
    public JsonResultEntity addShortAnswerQuestion(int lesson_id,int chapter_id,String question_content,String reference_answer,int score){
        JsonResultEntity message = new JsonResultEntity();
        try {
            int knowledge_id = knowledgeEntityRepository.findKnowledgeEntityByCorrChapterIdAndAndCorrLessonId(chapter_id,lesson_id).get(0).getKnowledgeId();
            shortAnswerQuestionEntityRepository.addShortAnswerQuestion(lesson_id,chapter_id,knowledge_id,question_content,reference_answer,score);
            message.errorCode = 200;
            message.status = true;
            message.data.put("symbol", true);
        } catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "添加失败！");
        }
        return message;
    }

    @Override
    public JsonResultEntity addChoiceQuestion(int lesson_id,int chapter_id,String question_content,String reference_answer, int score,String choice_A,String choice_B,String choice_C,String choice_D){
        JsonResultEntity message = new JsonResultEntity();
        try {
            int knowledge_id = knowledgeEntityRepository.findKnowledgeEntityByCorrChapterIdAndAndCorrLessonId(chapter_id,lesson_id).get(0).getKnowledgeId();
            choiceQuestionEntityRepository.addChoiceQuestion(lesson_id,chapter_id,knowledge_id,question_content,choice_A,choice_B,choice_C,choice_D,reference_answer,score);
            message.errorCode = 200;
            message.status = true;
            message.data.put("symbol", true);
        } catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "添加失败！");
        }
        return message;
    }
    @Override
    public JsonResultEntity giveRandomQuestion(int user_id){
        JsonResultEntity message = new JsonResultEntity();
        try {
            List<Integer> learnedChapterIdList = learnKnowledgeEntityRepository.findLearnedChapterIdByUserId(user_id);
            List<ShortAnswerQuestionEntity> overAllnotAnswered_SAQList = new ArrayList<>();
            List<ChoiceQuestionEntity> overAllnotAnswered_CQList = new ArrayList<>();
            for (int id:learnedChapterIdList){
                List<ShortAnswerQuestionEntity> tempSAQList = shortAnswerQuestionEntityRepository.findNotAnsweredShortAnswerQuestionEntitiesByChapter(id,user_id,"short_answer_question");
                overAllnotAnswered_SAQList.addAll(tempSAQList);
                List<ChoiceQuestionEntity> tempCQList = choiceQuestionEntityRepository.findNotAnsweredChoiceQuestionEntitiesByChapter(id,user_id,"short_answer_question");
                overAllnotAnswered_CQList.addAll(tempCQList);
            }

            List<ShortAnswerQuestionEntity> notAnswer_SAQList = new ArrayList<>();
            List<ChoiceQuestionEntity> notAnswer_CQList = new ArrayList<>();
            Integer RecentLearnedChapter = learnedChapterIdList.get(learnedChapterIdList.size()-1);

            for(ShortAnswerQuestionEntity SAQE: overAllnotAnswered_SAQList){
                if(SAQE.getCorrChapterId().equals(RecentLearnedChapter)){
                    notAnswer_SAQList.add(SAQE);
                }
                else{
                    Random rand = new Random();
                    if (notAnswer_SAQList.size() > (int) 1/3 * overAllnotAnswered_SAQList.size()){
                        continue;
                    }
                    if(rand.nextInt(overAllnotAnswered_SAQList.size()) >(int) 2/3 * overAllnotAnswered_SAQList.size()){
                        notAnswer_SAQList.add(SAQE);
                    }
                }
            }

            for(ChoiceQuestionEntity CQE: overAllnotAnswered_CQList){
                if(CQE.getCorrChapterId().equals(RecentLearnedChapter)){
                    notAnswer_CQList.add(CQE);
                }
                else{
                    Random rand = new Random();
                    if(notAnswer_CQList.size() > (int) 1/3 * overAllnotAnswered_CQList.size()){
                        continue;

                    }
                    if(rand.nextInt(overAllnotAnswered_CQList.size()) > (int) 4/5 * overAllnotAnswered_CQList.size() ){
                        notAnswer_CQList.add(CQE);
                    }
                }
            }

            List<Map<String, Object>> returnSAQList = new ArrayList<>();
            List<Map<String, Object>> returnCQList = new ArrayList<>();
            HashSet<ShortAnswerQuestionEntity> notAnswer_SAQSet = new HashSet<>(notAnswer_SAQList);
            HashSet<ChoiceQuestionEntity> notAnswer_CQSet = new HashSet<>(notAnswer_CQList);
            for(ShortAnswerQuestionEntity SAQ:notAnswer_SAQSet)
            {
                Map<String, Object> AnsweredSAQ = new HashMap<>();
                AnsweredSAQ.put("detail",SAQ);
                AnsweredSAQ.put("haveBeenAnswered",false);
                returnSAQList.add(AnsweredSAQ);
            }
            for(ChoiceQuestionEntity CQ:notAnswer_CQSet)
            {
                Map<String, Object> AnsweredCQ = new HashMap<>();
                AnsweredCQ.put("detail",CQ);
                AnsweredCQ.put("haveBeenAnswered",false);
                returnCQList.add(AnsweredCQ);
            }
            message.data.put("shortAnswerQuestionList",returnSAQList);
            message.data.put("choiceQuestionList",returnCQList);
            message.errorCode = 200;
            message.status = true;
        } catch (Exception e) {
            message.status = false;
            message.errorCode = 300;
            message.data.put("error", "添加失败！");
        }
        return message;

    }



}