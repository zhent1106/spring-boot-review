package com.soft1851.springboot.task.repository;

import com.soft1851.springboot.task.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CodeRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
public interface CodeRepository extends JpaRepository<Coder,Integer> {
    /**
     * 按id修改avatar
     *
     * @param avatar
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update coder set avatar = ?1 where id = ?2", nativeQuery = true)
    int updateAvatar(String avatar, long id);
}