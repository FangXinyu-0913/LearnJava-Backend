package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.AnswerSituationService;
import cn.edu.tongji.xfang.WebForJava.service.JudgeService;
import cn.edu.tongji.xfang.WebForJava.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: JudgeController
 * @Author Xinyu Fang
 * @Date: 2022/12/9 19:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/judge")
public class JudgeController {
    @Resource
    QuestionService questionService;
    @Resource
    JudgeService judgeService;

    @Resource
    AnswerSituationService answerSituationService;

    @CrossOrigin("*")
    @RequestMapping("getAllRecords")
    public JsonResultEntity getAllRecords() {
        return answerSituationService.findAllAnswerRecord();
    }

    @CrossOrigin("*")
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public JsonResultEntity judegeAnswerRecord(@RequestParam("answer_situation_id") int answerSituationId, @RequestParam("teacher_id") int teacherId, @RequestParam("score")int score) {
        return judgeService.JudgeAnswerSituation(answerSituationId, teacherId, score);
    }
}