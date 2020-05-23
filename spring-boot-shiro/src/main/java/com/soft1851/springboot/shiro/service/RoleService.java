package com.soft1851.springboot.shiro.service;

import com.soft1851.springboot.shiro.model.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
public interface RoleService {
    /**
     * 根据userId查询角色信息
     * @param id
     * @return
     */
    List<Role> findRoleByUserId(Integer id);
}
