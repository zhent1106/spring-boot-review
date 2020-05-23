package com.soft1851.springboot.shiro.mapper;

import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName PermissionMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
public interface PermissionMapper {
    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    List<String> findByRoleId(@Param("roleIds") List<Integer> roleIds);
}