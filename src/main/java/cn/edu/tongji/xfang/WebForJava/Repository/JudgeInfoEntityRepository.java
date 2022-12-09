package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.JudgeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: JudgeInfoEntityRepository
 * @Author Xinyu Fang
 * @Date: 2022/12/3 15:18
 * @Version 1.0
 */
public interface JudgeInfoEntityRepository extends JpaRepository<JudgeInfoEntity, Integer> {
    @Query(value = "select score from judge_info where answer_situation_id = ?1", nativeQuery = true)
    int findScoreByAnswerSituationId(int answer_situation_id);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into judge_info(teacher_id,score,answer_situation_id) values(?1,?2,?3)", nativeQuery = true)
    int judgeAnswer(int teacher_id, int score, int answer_situation_id);
}