package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.StudentInfoEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.TeacherInfoEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.StudentInfoEntity;
import cn.edu.tongji.xfang.WebForJava.models.TeacherInfoEntity;
import cn.edu.tongji.xfang.WebForJava.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: LoginServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/3 14:09
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    StudentInfoEntityRepository studentInfoEntityRepository;
    @Resource
    TeacherInfoEntityRepository teacherInfoEntityRepository;
    @Override
    public JsonResultEntity userLogin(String name, String password) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            StudentInfoEntity user = studentInfoEntityRepository.findStudentInfoEntityByStudentName(name);
            if (user.getStudentName().equals(name) && user.getStudentPassword().equals(password)) {
                message.data.put("user_id", user.getId());
                message.data.put("user_name", user.getStudentName());
                message.data.put("user_password", user.getStudentPassword());
                message.data.put("user_student_id", user.getStudentId());
                message.data.put("user_current_steps", user.getCurrentSteps());
                message.status = true;
                message.errorCode = 200;
            } else {
                message.status = false;
                message.errorCode = 300;
                message.data.put("error", "密码错误");
            }
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            return message;
        }
        return message;
    }

    @Override
    public JsonResultEntity teacherLogin(String name, String password){
        JsonResultEntity message = new JsonResultEntity();
        try {
            TeacherInfoEntity teacher = teacherInfoEntityRepository.findTeacherInfoEntityByTeacherName(name);
            if (teacher.getTeacherName().equals(name) && teacher.getTeacherPassword().equals(password)) {
                message.data.put("user_id", teacher.getId());
                message.data.put("user_name", teacher.getTeacherName());
                message.data.put("user_password", teacher.getTeacherPassword());
                message.data.put("user_formal_id", teacher.getTeacherId());
                message.status = true;
                message.errorCode = 200;
            } else {
                message.status = false;
                message.errorCode = 300;
                message.data.put("error", "密码错误");
            }
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            return message;
        }
        return message;
    }
}