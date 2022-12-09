package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.ChoiceQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.models.ShortAnswerQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Xinyu Fang
 */
public interface ShortAnswerQuestionEntityRepository extends JpaRepository<ShortAnswerQuestionEntity, Integer> {
    /**
     * 根据题目号查询题目信息
     * @param question_id 题目号
     * @return 返回题目信息
     */
    ShortAnswerQuestionEntity findShortAnswerQuestionEntityByShortAnswerQuestionId(int question_id);
    /**
     * 根据知识点查询题目信息
     * @param knowledge_id 知识点
     * @return 返回题目信息
     */
    List<ShortAnswerQuestionEntity> findShortAnswerQuestionEntitiesByCorrKnowledgeId(int knowledge_id);

    /**
     * 查询用户在该知识点下已作答题目信息
     * @param knowledge_id 知识点id
     * @param user_id 用户id
     * @param question_type 题目类型
     * @return 返回题目信息
     */
    @Query(value = "select * from short_answer_question where corr_knowledge_id = ?1 and short_answer_question_id in (select question_id from answer_situation where user_id = ?2 and question_type = ?3 )", nativeQuery = true)
    List<ShortAnswerQuestionEntity> findShortAnswerQuestionEntitiesByAnswerSituation(int knowledge_id, int user_id, String question_type);

    /**
     * 根据题目号查询题目分数
     * @param question_id 问题id
     * @return 返回题目分数
     */
    int findScoreByShortAnswerQuestionId(int question_id);

    /**
     * 查询用户在该章节下已作答题目信息
     * @param chapter_id 章节id
     * @param user_id 用户id
     * @param question_type 题目类型
     * @return 返回题目信息
     */
    @Query(value = "select * from short_answer_question where corr_chapter_id = ?1 and short_answer_question_id in (select question_id from answer_situation where user_id = ?2 and question_type = ?3 )", nativeQuery = true)
    List<ShortAnswerQuestionEntity> findShortAnswerQuestionEntitiesByChapter(int chapter_id, int user_id, String question_type);

    /**
     * 根据章节查询题目信息
     * @param chapter_id 章节id
     * @return 返回题目信息
     */
    List<ShortAnswerQuestionEntity> findShortAnswerQuestionEntitiesByCorrChapterId(int chapter_id);

    @Query(value = "select count(*) from short_answer_question where corr_chapter_id = ?1", nativeQuery = true)
    Integer findQueNumByCorrChapterId(int chapter_id);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into short_answer_question(corr_lesson_id, corr_chapter_id,corr_knowledge_id,question_content,reference_answer,score) values(?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    Integer addShortAnswerQuestion(int lesson_id,int chapter_id,int knowledge_id,String question_content,String reference_answer,int score);
}