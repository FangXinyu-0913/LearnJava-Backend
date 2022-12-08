package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LessonsEntityRepository extends JpaRepository<LessonsEntity, Integer> {
    @Query(value = "select * from lessons where lesson_id = ?1", nativeQuery = true)
    LessonsEntity findByLessonId(int lessonId);

    @Query(value = "select lesson_title from lessons where lesson_id = ?1", nativeQuery = true)
    String findLessonTitleByLessonId(int lessonId);
}