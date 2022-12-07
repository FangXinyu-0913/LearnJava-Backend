package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.ChaptersEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.KnowledgeEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.KnowledgeEntity;
import cn.edu.tongji.xfang.WebForJava.service.KnowledgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: Knowledge
 * @Author Xinyu Fang
 * @Date: 2022/12/6 10:42
 * @Version 1.0
 */
@Service
public class KnowledgeImpl implements KnowledgeService {
    @Resource
    ChaptersEntityRepository chaptersEntityRepository;
    @Resource
    KnowledgeEntityRepository knowledgeEntityRepository;

    @Override
    public KnowledgeEntity getKnowledgeInfo(int knowledge_id) throws Exception {
        return knowledgeEntityRepository.findKnowledgeEntityByknowledgeId(knowledge_id);
    }

    @Override
    public JsonResultEntity getKnowledgefromChapterAndLesson(int lesson_id, int chapter_id) throws Exception {
        JsonResultEntity message = new JsonResultEntity();
        try {
            message.data.put("knowledge", knowledgeEntityRepository.findKnowledgeEntityByCorrChapterIdAndAndCorrLessonId(chapter_id,lesson_id));
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }

    @Override
    public JsonResultEntity getChapterfromLesson(int lesson_id) throws Exception {
        JsonResultEntity message = new JsonResultEntity();
        try {
            message.data.put("chapter", chaptersEntityRepository.findChaptersEntityByLessonId(lesson_id));
            message.status = true;
            message.errorCode = 200;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }
}