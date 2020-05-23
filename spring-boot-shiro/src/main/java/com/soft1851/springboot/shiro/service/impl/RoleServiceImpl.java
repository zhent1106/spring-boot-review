package com.soft1851.springboot.shiro.service.impl;

import com.soft1851.springboot.shiro.mapper.RoleMapper;
import com.soft1851.springboot.shiro.model.Role;
import com.soft1851.springboot.shiro.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 根据userId查询角色信息
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(Integer id) {
        return roleMapper.findRoleByUserId(id);
    }
}