package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.KnowledgeService;
import cn.edu.tongji.xfang.WebForJava.service.LearnService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: KnowledgeController
 * @Author Xinyu Fang
 * @Date: 2022/12/6 10:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/knowledge")
public class KnowledgeController {
    @Resource
    KnowledgeService knowledgeService;

    @Resource
    LearnService learnService;

    @CrossOrigin("*")
    @RequestMapping("get")
    public JsonResultEntity getKnowledge(@RequestParam("knowledge_id") int knowledge_id)  throws Exception {
        JsonResultEntity message = new JsonResultEntity();
        message.data.put("knowledge", knowledgeService.getKnowledgeInfo(knowledge_id));
        return message;
    }

    @CrossOrigin("*")
    @RequestMapping("getList")
    public JsonResultEntity getKnowledgefromChapterAndLesson(@RequestParam("lesson_id") int lesson_id, @RequestParam("chapter_id") int chapter_id,@RequestParam("user_id") int user_id) throws Exception {
        return knowledgeService.getKnowledgefromChapterAndLesson(lesson_id, chapter_id, user_id);
    }

    @CrossOrigin("*")
    @RequestMapping("learn")
    public JsonResultEntity learnKnowledge(@RequestParam("knowledge_id") int knowledge_id, @RequestParam("user_id") int user_id, @RequestParam("lesson_id") int lesson_id, @RequestParam("chapter_id") int chapter_id)  throws Exception {
        return learnService.userLearnKnowledge(user_id,knowledge_id,lesson_id,chapter_id);
    }

    @CrossOrigin("*")
    @RequestMapping("learnRecord")
    public JsonResultEntity getlearnKnowledgeRecord(@RequestParam("lesson_id") int lesson_id, @RequestParam("user_id") int user_id)  throws Exception {
        return learnService.getLearnKnowledgeRecordByLessonAndUser(user_id,lesson_id);
    }

}