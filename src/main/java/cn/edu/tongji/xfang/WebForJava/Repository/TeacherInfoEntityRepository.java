package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.StudentInfoEntity;
import cn.edu.tongji.xfang.WebForJava.models.TeacherInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Xinyu Fang
 */
public interface TeacherInfoEntityRepository extends JpaRepository<TeacherInfoEntity, Integer> {
    /**
     * 根据教师号查询教师信息
     * @param teacher_id 教师号
     * @return 返回教师信息
     */
    TeacherInfoEntity findTeacherInfoEntityById(int teacher_id);

    /**
     * 根据用户名查询教师信息
     * @param teacher_name 用户名
     * @return 返回学生信息
     */
    TeacherInfoEntity findTeacherInfoEntityByTeacherName(String teacher_name);
}