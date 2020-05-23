package com.soft1851.springboot.shiro.mapper;

import com.soft1851.springboot.shiro.model.User;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
public interface UserMapper {
    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    User findByAccount(@Param("account") String account);
}