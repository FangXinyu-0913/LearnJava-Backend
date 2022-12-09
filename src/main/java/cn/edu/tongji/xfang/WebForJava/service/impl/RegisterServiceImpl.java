package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.StudentInfoEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.TeacherInfoEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.TeacherInfoEntity;
import cn.edu.tongji.xfang.WebForJava.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: RegisterServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/10 0:51
 * @Version 1.0
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    StudentInfoEntityRepository studentInfoEntityRepository;
    @Resource
    TeacherInfoEntityRepository teacherInfoEntityRepository;
    @Override
    public JsonResultEntity userRegister(String name, String password) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            studentInfoEntityRepository.addStudent(name, password);
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.status = false;
            message.errorCode = 400;
            return message;
        }
        return message;

    }

    @Override
    public JsonResultEntity teacherRegister(String name, String password) {
        JsonResultEntity message = new JsonResultEntity();
        try {
            teacherInfoEntityRepository.addTeacher(name, password);
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.status = false;
            message.errorCode = 400;
            return message;
        }
        return message;

    }
}