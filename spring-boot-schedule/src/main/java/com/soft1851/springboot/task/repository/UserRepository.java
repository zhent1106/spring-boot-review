package com.soft1851.springboot.task.repository;

import com.soft1851.springboot.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/15
 **/
public interface UserRepository  extends JpaRepository<User,Integer> {

    /**
     * 查询月份日期与当天相等的数据
     * @return
     */
    @Query(value = "SELECT * FROM user WHERE MONTH(birthday) = MONTH(NOW()) AND DAY(birthday) = DAY(NOW())",nativeQuery = true)
    List<User> findUsersByBirthday();
}