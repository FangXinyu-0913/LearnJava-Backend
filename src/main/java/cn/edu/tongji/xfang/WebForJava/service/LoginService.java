package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import org.springframework.stereotype.Service;

/**
 * @title: LoginService
 * @Author Xinyu Fang
 * @Date: 2022/12/3 14:06
 * @Version 1.0
 */
@Service
public interface LoginService {
    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return 返回登录结果
     */
    JsonResultEntity userLogin(String name, String password);
    /**
     * 教师登录
     * @param name 用户名
     * @param password 密码
     * @return 返回登录结果
     */
    JsonResultEntity teacherLogin(String name, String password);
}