package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.LessonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: ClassController
 * @Author Xinyu Fang
 * @Date: 2022/12/6 9:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/lesson")
public class LessonController {
    @Resource
    LessonService lessonService;

    @CrossOrigin("*")
    @RequestMapping("getAll")
    public JsonResultEntity getLesson() throws Exception {
        return lessonService.getLessons();
    }

    @CrossOrigin("*")
    @RequestMapping("selected")
    public JsonResultEntity getSelectedLesson(@RequestParam("student_id") int student_id) throws Exception {
        return lessonService.getChooseLessons(student_id);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public JsonResultEntity addLesson(@RequestParam("lesson_title") String lesson_title, @RequestParam("lesson_content") String lesson_content) throws Exception {
        return lessonService.addLessons(lesson_title, lesson_content);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "choose",method = RequestMethod.POST)
    public JsonResultEntity chooseLesson(@RequestParam("student_id") int student_id, @RequestParam("lesson_id") int lesson_id) throws Exception {
        return lessonService.chooseLesson(lesson_id, student_id);
    }

}