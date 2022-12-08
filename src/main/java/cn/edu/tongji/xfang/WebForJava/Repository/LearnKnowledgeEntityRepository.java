package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.KnowledgeEntity;
import cn.edu.tongji.xfang.WebForJava.models.LearnKnowledgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface LearnKnowledgeEntityRepository extends JpaRepository<LearnKnowledgeEntity, Integer> {
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into learn_knowledge(user_id,knowledge_id,lesson_id,chapter_id,learn_time) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    int userLearnKnowledge(int userId, int knowledgeId, int lessonId,int chapterId, Timestamp learnTime);

    /**
     * 查询该用户是否已经学习过该知识点
     * @param userId
     * @param knowledgeId
     * @return
     */
    @Query(value = "select * from learn_knowledge where user_id = ?1 and knowledge_id = ?2",nativeQuery = true)
    List<LearnKnowledgeEntity> findLearnKnowledgeByUserIdAndKnowledgeId(int userId, int knowledgeId);

    @Query(value = "select * from learn_knowledge where user_id = ?1 and lesson_id = ?2",nativeQuery = true)
    List<LearnKnowledgeEntity> findLearnRecordByUserIdAndLessonId(int userId, int lessonId);

    @Query(value = "select count(*) from learn_knowledge where user_id = ?3 and lesson_id = ?2 and chapter_id =?1",nativeQuery = true)
    Integer countLearnKnowledgeNumByCorrChapterIdAndAndCorrLessonIdAndAndCorrUserId(int chapter_id,int lesson_id,int user_id);



}
