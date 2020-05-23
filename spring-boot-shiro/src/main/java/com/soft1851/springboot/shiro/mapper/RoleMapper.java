package com.soft1851.springboot.shiro.mapper;

import com.soft1851.springboot.shiro.model.Role;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
public interface RoleMapper {
    /**
     * 根据userId查询角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(@Param("userId") Integer userId);
}
