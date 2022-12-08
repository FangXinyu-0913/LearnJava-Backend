package cn.edu.tongji.xfang.WebForJava.service.impl;

import cn.edu.tongji.xfang.WebForJava.Repository.ChaptersEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.KnowledgeEntityRepository;
import cn.edu.tongji.xfang.WebForJava.Repository.LearnKnowledgeEntityRepository;
import cn.edu.tongji.xfang.WebForJava.models.JsonResultEntity;
import cn.edu.tongji.xfang.WebForJava.models.LearnKnowledgeEntity;
import cn.edu.tongji.xfang.WebForJava.service.LearnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * @title: LearnServiceImpl
 * @Author Xinyu Fang
 * @Date: 2022/12/8 19:48
 * @Version 1.0
 */
@Service
public class LearnServiceImpl implements LearnService {
    @Resource
    LearnKnowledgeEntityRepository learnKnowledgeEntityRepository;
    @Resource
    ChaptersEntityRepository chaptersEntityRepository;
    @Resource
    KnowledgeEntityRepository knowledgeEntityRepository;
    @Override
    public JsonResultEntity userLearnKnowledge(int userId, int knowledgeId, int lessonId,int chapterId) {
        JsonResultEntity message = new JsonResultEntity();
        try{
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            int symbol = learnKnowledgeEntityRepository.userLearnKnowledge(userId,knowledgeId,lessonId, chapterId, timestamp);
            message.data.put("signal", symbol);
            message.errorCode = 200;
            message.status = true;
        } catch (Exception e) {
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }
    @Override
    public JsonResultEntity getLearnKnowledgeRecordByLessonAndUser(int userId, int lessonId){
        JsonResultEntity message = new JsonResultEntity();
        try {
            List<Integer> chapterIdList = chaptersEntityRepository.findAllChapterIdByLessonId(lessonId);
            List<Map<String,Object>> knowledgeList = new ArrayList<>();
            for (Integer chapterId:chapterIdList){
                Map<String,Object> infor = new HashMap<>();
                Integer knowledgeNum = knowledgeEntityRepository.countKnowledgeNumByCorrChapterIdAndAndCorrLessonId(chapterId,lessonId);
                Integer learnKnowledgeNum = learnKnowledgeEntityRepository.countLearnKnowledgeNumByCorrChapterIdAndAndCorrLessonIdAndAndCorrUserId(chapterId,lessonId,userId);
                infor.put("chapter_id",chapterId);
                infor.put("chapter_title",chaptersEntityRepository.findChapterNameByChapterId(chapterId));
                infor.put("chapter_content",chaptersEntityRepository.findChapterContentByChapterId(chapterId));
                infor.put("overall_knowledge_num",knowledgeNum);
                infor.put("learnt_knowledge_num",learnKnowledgeNum);
                knowledgeList.add(infor);
            }
            message.data.put("learn_record", knowledgeList);
            message.errorCode = 200;
            message.status = true;
        }catch (Exception e){
            message.data.put("error", e.getMessage());
            message.errorCode = 300;
            message.status = false;
            return message;
        }
        return message;
    }
}