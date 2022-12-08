package cn.edu.tongji.xfang.WebForJava.controller;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.service.LearnService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: LearnRecordController
 * @Author Xinyu Fang
 * @Date: 2022/12/8 22:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/learnRecord")
public class LearnRecordController {
    @Resource
    LearnService learnService;

}