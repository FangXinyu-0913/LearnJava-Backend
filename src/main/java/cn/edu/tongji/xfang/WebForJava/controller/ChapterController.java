package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.KnowledgeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: ChapterController
 * @Author Xinyu Fang
 * @Date: 2022/12/6 11:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/chapter")
public class ChapterController {
    @Resource
    KnowledgeService knowledgeService;

    @CrossOrigin("*")
    @RequestMapping("fromLesson")
    public JsonResultEntity getChapterfromLesson(@RequestParam("lesson_id") int lesson_id) throws Exception {
        return knowledgeService.getChapterfromLesson(lesson_id);
    }
}