package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.ChoiceQuestionEntity;
import cn.edu.tongji.xfang.WebForJava.models.ShortAnswerQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * @title: ChoiceQuestionRepository
 * @Author Xinyu Fang
 * @Date: 2022/12/6 10:42
 * @Version 1.0
 */
public interface ChoiceQuestionEntityRepository extends JpaRepository<ChoiceQuestionEntity, Integer> {
    /**
     * 根据题目号查询题目信息
     * @param question_id 题目号
     * @return 返回题目信息
     */
    ChoiceQuestionEntity findChoiceQuestionEntityByChoiceQuestionId(int question_id);
    /**
     * 根据知识点查询题目信息
     * @param knowledge_id 知识点
     * @return 返回题目信息
     */
    List<ChoiceQuestionEntity> findChoiceQuestionEntitiesByCorrKnowledgeId(int knowledge_id);
    /**
     * 查询用户在该知识点下已作答题目信息
     * @param knowledge_id 知识点id
     * @param user_id 用户id
     * @param question_type 题目类型
     * @return 返回题目信息
     */
    @Query(value = "select * from choice_question where corr_knowledge_id = ?1 and choice_question_id in (select question_id from answer_situation where user_id = ?2 and question_type = ?3 )", nativeQuery = true)
    List<ChoiceQuestionEntity> findChoiceQuestionEntitiesByAnswerSituation(int knowledge_id, int user_id, String question_type);


    /**
     * 根据题目号查询题目分数
     * @param question_id 问题id
     * @return 返回题目分数
     */
    int findScoreByChoiceQuestionId(int question_id);
}