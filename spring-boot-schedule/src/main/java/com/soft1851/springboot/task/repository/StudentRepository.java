package com.soft1851.springboot.task.repository;

import com.soft1851.springboot.task.model.T_Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName StudentRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
public interface StudentRepository extends JpaRepository<T_Student,Integer> {
}
