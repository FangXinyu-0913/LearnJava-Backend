package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.LessonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}