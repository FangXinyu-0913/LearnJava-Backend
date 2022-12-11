package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.ChooseLessonEntityPK;
import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Xinyu Fang
 */
public interface ChooseLessonsEntityRepository extends JpaRepository<LessonsEntity, ChooseLessonEntityPK> {
    /**
     * 根据课程号查询课程信息
     * @param lesson_id 课程号
     * @return 返回课程信息
     */
    @Query(value = "select * from lessons where id = ?1", nativeQuery = true)
    LessonsEntity findLessonsEntityById(int lesson_id);

    /**
     * 返回全部课程信息
     * @return 返回全部课程信息
     */
    @Query(value = "select * from lessons", nativeQuery = true)
    @Override
    List<LessonsEntity> findAll();

    /**
     * 根据学生学号返回全部课程信息
     * @param student_id 学生学号
     * @return 返回全部课程信息
     */
    @Query(value = "select * from lessons where lesson_id in (select lesson_id from choose_lesson where student_id = ?1)", nativeQuery = true)
    List<LessonsEntity> findLessonsEntityByStudentId(int student_id);

    /**
     * 学生选课
     * @param student_id 学生学号
     * @param lesson_id 课程号
     * @return 返回选课结果
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into choose_lesson(student_id,lesson_id) values(?1,?2)", nativeQuery = true)
    int chooseLesson(int student_id, int lesson_id);
}