package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import org.springframework.stereotype.Service;

/**
 * @author Xinyu Fang
 */
@Service
public interface LessonService {
    /**
     * 根据课程号查询课程信息
     * @param lesson_id 课程号
     * @return 返回课程信息
     */
    LessonsEntity getLessonInfo(int lesson_id) throws Exception;

    /**
     * 根据学生学号返回全部课程信息
     * @param student_id 学生学号
     * @return 返回全部课程信息
     */
    JsonResultEntity getChooseLessons(int student_id) throws Exception;

    /**
     * 返回全部课程信息
     * @return 返回全部课程信息
     */
    JsonResultEntity getLessons() throws Exception;


}