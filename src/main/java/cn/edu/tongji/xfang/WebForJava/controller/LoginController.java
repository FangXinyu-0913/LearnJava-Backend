package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: LoginController
 * @Author Xinyu Fang
 * @Date: 2022/12/3 15:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Resource
    LoginService loginService;

    @CrossOrigin("*")
    @RequestMapping("user")
    public JsonResultEntity userLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
        return loginService.userLogin(name, password);
    }

    @CrossOrigin("*")
    @RequestMapping("teacher")
    public JsonResultEntity teacherLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
        return loginService.teacherLogin(name, password);
    }
}