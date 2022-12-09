package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.KnowledgeService;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin("*")
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public JsonResultEntity addChapter(@RequestParam("lesson_id") int lesson_id,@RequestParam("chapter_title") String chapter_title,@RequestParam("chapter_content") String chapter_content) throws Exception {
        return knowledgeService.addChapter(lesson_id,chapter_title,chapter_content);
    }
}