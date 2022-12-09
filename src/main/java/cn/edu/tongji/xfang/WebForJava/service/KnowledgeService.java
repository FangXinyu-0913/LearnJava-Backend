package cn.edu.tongji.xfang.WebForJava.service;

import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.KnowledgeEntity;
import org.hibernate.annotations.Source;
import org.springframework.stereotype.Service;
/**
 * @title: KnowledgeService
 * @Author Xinyu Fang
 * @Date: 2022/12/6 9:39
 * @Version 1.0
 */
@Service
public interface KnowledgeService {

    /**
     * 根据知识点id查询知识点信息
     * @param knowledge_id 知识点id
     * @return 返回知识点信息
     */
    KnowledgeEntity getKnowledgeInfo(int knowledge_id) throws Exception;

    /**
     * 根据课程id返回全部知识点信息
     * @param lesson_id 课程id
     * @return 返回全部知识点信息
     */
    JsonResultEntity getKnowledgefromChapterAndLesson(int lesson_id,int chapter_id,int user_id) throws Exception;


    /**
     * 根据课程id返回全部章节信息
     * @param lesson_id 课程id
     * @return 返回全部知识点信息
     */
    JsonResultEntity getChapterfromLesson(int lesson_id) throws Exception;

    /**
     * 添加章节知识点入库
     * @param lesson_id 课程id
     * @param chapter_title 章节标题
     * @param chapter_content 章节内容
     */
    JsonResultEntity addChapter(int lesson_id,String chapter_title,String chapter_content) throws Exception;

    /**
     * 添加知识点入库
     * @param lesson_id 课程id
     * @param chapter_id 章节id
     * @param knowledge_content 知识点内容
     */
    JsonResultEntity addKnowledge(int lesson_id,int chapter_id,String knowledge_content) throws Exception;
}
