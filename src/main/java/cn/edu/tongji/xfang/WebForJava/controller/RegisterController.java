package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.service.QuestionService;
import cn.edu.tongji.xfang.WebForJava.service.RegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: RegisterController
 * @Author Xinyu Fang
 * @Date: 2022/12/10 0:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Resource
    RegisterService registerService;

    @CrossOrigin("*")
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Object userRegister(@RequestParam("name") String name,@RequestParam("password") String password) {
        return registerService.userRegister(name, password);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public Object teacherRegister(@RequestParam("name") String name,@RequestParam("password") String password) {
        return registerService.teacherRegister(name, password);
    }
}