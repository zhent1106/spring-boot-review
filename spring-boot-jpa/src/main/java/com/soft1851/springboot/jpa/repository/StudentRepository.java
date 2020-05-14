package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName StudentRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * 根据班级id查询学生列表
     *
     * @param id
     * @return
     */
    @Query(value = "select id,student_name,age from student  where clazz_id = ?1", nativeQuery = true)
    List<Student> findByClazzId(int id);
}