package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.ChooseLessonsEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.LessonsEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import cn.edu.tongji.xfang.WebForJava.service.LessonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: LessonServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/6 9:17
 * @Version 1.0
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Resource
    ChooseLessonsEntityRepository chooseLessonsEntityRepository;

    @Resource
    LessonsEntityRepository lessonsEntityRepository;
    @Override
    /**
     * 课程信息查询
     * @param lesson_id 课程号
     * @return 返回课程实体信息
     */
    public LessonsEntity getLessonInfo(int lesson_id) {
        return chooseLessonsEntityRepository.findLessonsEntityById(lesson_id);
    }

    @Override
    /**
     * 学生选课信息查询
     * @param student_id 学生学号
     * @return 返回选课信息
     */
    public JsonResultEntity getChooseLessons(int student_id) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            message.data.put("lessons", chooseLessonsEntityRepository.findLessonsEntityByStudentId(student_id));
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }

    @Override
    /**
     *
     */
    public JsonResultEntity getLessons(){
        JsonResultEntity message = new JsonResultEntity();
        try {
            message.data.put("lessons", chooseLessonsEntityRepository.findAll());
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }

    @Override
    public JsonResultEntity addLessons(String lessonTitle, String lessonContent){
        JsonResultEntity message = new JsonResultEntity();
        try {
            int symbol = lessonsEntityRepository.addLesson(lessonTitle, lessonContent);
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }
    @Override
    public JsonResultEntity chooseLesson(int lessonId, int userId) throws Exception{
        JsonResultEntity message = new JsonResultEntity();
        System.out.println(lessonId);
        System.out.println(userId);
        try {
            int symbol = chooseLessonsEntityRepository.chooseLesson(userId,lessonId);
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }

}
