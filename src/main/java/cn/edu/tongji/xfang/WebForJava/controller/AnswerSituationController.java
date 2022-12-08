package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.AnswerSituationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: AnswerSituationController
 * @Author Xinyu Fang
 * @Date: 2022/12/8 13:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/answerSituation")
public class AnswerSituationController {
    @Resource
    AnswerSituationService answerSituationService;

    @CrossOrigin("*")
    @RequestMapping("getByuserId")
    public JsonResultEntity getAnswerSituationByUserId(@RequestParam("user_id") int userId) throws Exception {
        return answerSituationService.findAllRecordsByUserId(userId);
    }


}