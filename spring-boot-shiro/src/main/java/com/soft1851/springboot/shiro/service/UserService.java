package com.soft1851.springboot.shiro.service;

import com.soft1851.springboot.shiro.model.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
public interface UserService {
    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    User findByAccount(String account);
}
