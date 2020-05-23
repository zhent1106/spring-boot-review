package com.soft1851.springboot.shiro.service.impl;

import com.soft1851.springboot.shiro.mapper.UserMapper;
import com.soft1851.springboot.shiro.model.User;
import com.soft1851.springboot.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }
}