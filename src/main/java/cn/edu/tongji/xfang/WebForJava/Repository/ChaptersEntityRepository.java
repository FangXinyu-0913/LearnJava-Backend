package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.ChaptersEntity;
import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Xinyu Fang
 */
public interface ChaptersEntityRepository extends JpaRepository<ChaptersEntity, Integer> {
    @Query(value = "select * from chapters where corr_lesson_id = ?1", nativeQuery = true)
    List<ChaptersEntity> findChaptersEntityByLessonId(int lesson_id);

    @Query(value = "select chapter_id from chapters where corr_lesson_id = ?1", nativeQuery = true)
    List<Integer> findAllChapterIdByLessonId(int lesson_id);

    @Query(value = "select * from chapters where chapter_id = ?1", nativeQuery = true)
    ChaptersEntity findChapterByChapterId(int chapter_id);

    @Query(value = "select chapter_title from chapters where chapter_id = ?1", nativeQuery = true)
    String findChapterNameByChapterId(int chapter_id);

}