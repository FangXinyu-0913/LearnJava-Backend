package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}