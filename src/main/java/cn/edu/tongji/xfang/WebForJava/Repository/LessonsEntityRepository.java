package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LessonsEntityRepository extends JpaRepository<LessonsEntity, Integer> {
    @Query(value = "select * from lessons where lesson_id = ?1", nativeQuery = true)
    LessonsEntity findByLessonId(int lessonId);

    @Query(value = "select lesson_title from lessons where lesson_id = ?1", nativeQuery = true)
    String findLessonTitleByLessonId(int lessonId);

    /**
     * 新增一门课程
     * @param lessonTitle 课程名
     * @param lessonContent 课程内容
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into lessons(lesson_title,lesson_content) values(?1,?2)", nativeQuery = true)
    int addLesson(String lessonTitle, String lessonContent);
}