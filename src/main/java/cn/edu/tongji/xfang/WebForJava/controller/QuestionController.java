package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: QuestionController
 * @Author Xinyu Fang
 * @Date: 2022/12/6 14:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Resource
    QuestionService questionService;

    @CrossOrigin("*")
    @RequestMapping("detailWithSituation")
    public JsonResultEntity getSelectedLesson(@RequestParam("knowledge_id") int corrKnowledgeId, @RequestParam("user_id") int userId) throws Exception {
        return questionService.getRelatedQuestion(corrKnowledgeId,userId);
    }

    @CrossOrigin("*")
    @RequestMapping("chapter")
    public JsonResultEntity getSelectedQue(@RequestParam("chapter_id") int corrChapterId, @RequestParam("user_id") int userId) throws Exception {
        return questionService.getRelatedQuestionByChapter(corrChapterId,userId);
    }

    @CrossOrigin("*")
    @RequestMapping("lesson")
    public JsonResultEntity getQueInfoByLesson(@RequestParam("lesson_id") int corrLessonId, @RequestParam("user_id") int userId) throws Exception {
        return questionService.getUserChapterQuestionInfoByLesson(corrLessonId,userId);
    }

    @CrossOrigin("*")
    @RequestMapping(value ="answer",method = RequestMethod.POST)
    public JsonResultEntity postAnswer(@RequestParam("question_type") String questionType, @RequestParam("question_id") int questionId, @RequestParam("user_id") int userId, @RequestParam("user_answer") String userAnswer) throws Exception {
        return questionService.answerQuestion(questionType,questionId,userId,userAnswer);
    }

    @CrossOrigin("*")
    @RequestMapping(value ="post",method = RequestMethod.POST)
    public JsonResultEntity postQuestion(@RequestParam("question_type") String question_type, @RequestParam("lesson_id") int lesson_id, @RequestParam("chapter_id") int chapter_id, @RequestParam("question_content") String question_content, @RequestParam("reference_answer") String reference_answer, @RequestParam("score") int score, @RequestParam("choice_A") String choice_A,@RequestParam("choice_B") String choice_B,@RequestParam("choice_C") String choice_C,@RequestParam("choice_D") String choice_D) throws Exception {
        if(question_type.equals("choice_question")) {
            return questionService.addChoiceQuestion(lesson_id,chapter_id,question_content, reference_answer, score, choice_A,choice_B,choice_C, choice_D);
        }
        else{
            return questionService.addShortAnswerQuestion(lesson_id, chapter_id, question_content, reference_answer, score);
        }

    }




}