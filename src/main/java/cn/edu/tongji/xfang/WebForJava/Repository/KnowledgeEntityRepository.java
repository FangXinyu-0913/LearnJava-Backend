package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.KnowledgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KnowledgeEntityRepository extends JpaRepository<KnowledgeEntity, Integer> {
    /**
     * 根据知识点号查询知识点信息
     * @param knowledge_id 知识点号
     * @return 返回知识点信息
     */
    KnowledgeEntity findKnowledgeEntityByknowledgeId(int knowledge_id);

    /**
     * 根据章节号和课程号查询知识点信息
     * @param chapter_id 章节号
     * @param lesson_id 课程号
     * @return 返回知识点信息
     */
    List<KnowledgeEntity> findKnowledgeEntityByCorrChapterIdAndAndCorrLessonId(int chapter_id,int lesson_id);

    @Query(value = "select count(*) from knowledge where corr_chapter_id = ?1 and corr_lesson_id = ?2",nativeQuery = true)
    Integer countKnowledgeNumByCorrChapterIdAndAndCorrLessonId(int chapter_id,int lesson_id);
}