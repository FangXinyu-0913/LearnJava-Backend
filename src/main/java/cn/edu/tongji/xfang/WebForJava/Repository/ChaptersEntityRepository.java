package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.ChaptersEntity;
import cn.edu.tongji.xfang.WebForJava.models.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Query(value = "select chapter_content from chapters where chapter_id = ?1", nativeQuery = true)
    String findChapterContentByChapterId(int chapter_id);

    /**
     * 添加章节
     * @param corr_lesson_id 对应课程id
     * @param chapter_title 章节名
     * @param chapter_content 章节内容
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into chapters(corr_lesson_id,chapter_title,chapter_content) values(?1,?2,?3)", nativeQuery = true)
    int addChapter(int corr_lesson_id,String chapter_title,String chapter_content);



}