package cn.edu.tongji.xfang.WebForJava.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: JsonResultEntity
 * @Author Xinyu Fang
 * @Date: 2022/12/3 15:02
 * @Version 1.0
 */
@Data
public class JsonResultEntity {
    public int errorCode;
    public boolean status;

    public Map<String, Object> data;

    public JsonResultEntity() {
        this.errorCode = 300;
        this.status = false;
        this.data = new HashMap<>();
    }
}