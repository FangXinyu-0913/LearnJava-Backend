package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.AnswerSituationEntity;
import cn.edu.tongji.xfang.WebForJava.models.ChaptersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Xinyu Fang
 */
public interface AnswerSituationEntityRepository extends JpaRepository<AnswerSituationEntity, Integer> {
    /**
     * 用问题id和用户id获取某条记录
     * @param question_id
     * @param user_id
     * @param question_type
     * @return
     */
    @Query(value ="select user_answer from answer_situation where question_type = ?1 and question_id = ?2 and user_id = ?3", nativeQuery = true)
    String findUserAnswerByQuestionIdAndUserId(String question_type,int question_id,int user_id);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into answer_situation(question_type,question_id,user_id,user_answer) values(?1,?2,?3,?4)",nativeQuery = true)
    int userAnswerQuestion(String question_type,int question_id,int user_id,String answer);

    /**
     * 获取用户所有答题记录
     * @param user_id
     * @return List<AnswerSituationEntity>
     */
    @Query(value ="select * from answer_situation where user_id = ?1", nativeQuery = true)
    List<AnswerSituationEntity> findAllAnswerRecordByUserId(int user_id);

}