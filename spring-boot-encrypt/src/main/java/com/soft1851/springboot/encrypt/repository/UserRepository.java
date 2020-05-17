package com.soft1851.springboot.encrypt.repository;

import com.soft1851.springboot.encrypt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/15
 **/
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据密码查询用户
     * @param password
     * @return
     */
  List<User> findByPassword(String password);

}