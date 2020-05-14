package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName TeacherRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
public interface TeacherRepository  extends JpaRepository<Teacher, Integer> {
    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Teacher findTeacherByIdEquals(int id);
}