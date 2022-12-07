package cn.edu.tongji.xfang.WebForJava.Repository;

import cn.edu.tongji.xfang.WebForJava.models.StudentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @title: StudentInfoEntityRepository
 * @Author Xinyu Fang
 * @Date: 2022/12/3 15:18
 * @Version 1.0
 */
@Repository
public interface StudentInfoEntityRepository extends JpaRepository<StudentInfoEntity, Integer> {
    /**
     * 根据学号查询学生信息
     * @param student_id 学号
     * @return 返回学生信息
     */
    StudentInfoEntity findStudentInfoEntityById(int student_id);

    /**
     * 根据用户名查询学生信息
     * @param student_name 用户名
     * @return 返回学生信息
     */
    StudentInfoEntity findStudentInfoEntityByStudentName(String student_name);


}