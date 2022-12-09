package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    /**
     * 用户注册
     * @param name 用户名
     * @param password 密码
     * @return 返回注册结果
     */
    JsonResultEntity userRegister(String name, String password);

    /**
     * 教师注册
     * @param name 教师用户名
     * @param password 密码
     * @return 返回注册结果
     */
    JsonResultEntity teacherRegister(String name, String password);
}
