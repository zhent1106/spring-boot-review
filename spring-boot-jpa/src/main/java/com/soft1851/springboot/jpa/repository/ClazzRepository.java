package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ClazzRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    /**
     * 根据id查询班级
     *
     * @param id
     * @return
     */
    Clazz findClazzByIdEquals(int id);
}