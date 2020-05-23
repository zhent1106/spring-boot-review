package com.soft1851.springboot.shiro.service.impl;

import com.soft1851.springboot.shiro.mapper.PermissionMapper;
import com.soft1851.springboot.shiro.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    @Override
    public List<String> findByRoleId(List<Integer> roleIds) {
        return permissionMapper.findByRoleId(roleIds);
    }
}