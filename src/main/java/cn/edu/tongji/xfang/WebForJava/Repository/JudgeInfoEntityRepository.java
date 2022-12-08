package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.JudgeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: JudgeInfoEntityRepository
 * @Author Xinyu Fang
 * @Date: 2022/12/3 15:18
 * @Version 1.0
 */
public interface JudgeInfoEntityRepository extends JpaRepository<JudgeInfoEntity, Integer> {
    @Query(value = "select score from judge_info where answer_situation_id = ?1", nativeQuery = true)
    int findScoreByAnswerSituationId(int answer_situation_id);
}