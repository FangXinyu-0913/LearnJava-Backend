package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.ChaptersEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.KnowledgeEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.LearnKnowledgeEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.KnowledgeEntity;
import cn.edu.tongji.xfang.WebForJava.service.KnowledgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: Knowledge
 * @Author Xinyu Fang
 * @Date: 2022/12/6 10:42
 * @Version 1.0
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Resource
    ChaptersEntityRepository chaptersEntityRepository;
    @Resource
    KnowledgeEntityRepository knowledgeEntityRepository;
    @Resource
    LearnKnowledgeEntityRepository learnKnowledgeEntityRepository;
    @Override
    public KnowledgeEntity getKnowledgeInfo(int knowledge_id) throws Exception {
        return knowledgeEntityRepository.findKnowledgeEntityByknowledgeId(knowledge_id);
    }

    @Override
    public JsonResultEntity getKnowledgefromChapterAndLesson(int lesson_id, int chapter_id,int user_id) throws Exception {
        JsonResultEntity message = new JsonResultEntity();
        try {
            List<KnowledgeEntity> KEList = knowledgeEntityRepository.findKnowledgeEntityByCorrChapterIdAndAndCorrLessonId(chapter_id,lesson_id);
            List<Map<String,Object>> KEMapList = new ArrayList<>();
            for(KnowledgeEntity KE : KEList){
                Map<String,Object> temp = new HashMap<>();
                temp.put("knowledge_id", KE.getKnowledgeId());
                temp.put("knowledge_content",KE.getKnowledgeContent());
                temp.put("corr_chapter_id",KE.getCorrChapterId());
                temp.put("corr_lesson_id",KE.getCorrLessonId());
                temp.put("already_learned",learnKnowledgeEntityRepository.findLearnKnowledgeByUserIdAndKnowledgeId(user_id,KE.getKnowledgeId()).size());
                KEMapList.add(temp);
            }
            message.data.put("knowledge", KEMapList);
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

    @Override
    public JsonResultEntity addChapter(int lesson_id,String chapter_title,String chapter_content) throws Exception{
        JsonResultEntity message = new JsonResultEntity();
        try {
            chaptersEntityRepository.addChapter(lesson_id,chapter_title,chapter_content);
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
    public JsonResultEntity addKnowledge(int lesson_id,int chapter_id,String knowledge_content) throws Exception{
        JsonResultEntity message = new JsonResultEntity();
        try {
            knowledgeEntityRepository.addKnowledge(chapter_id,lesson_id,knowledge_content);
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