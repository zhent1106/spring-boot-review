package com.soft1851.springboot.shiro.config;

import com.soft1851.springboot.shiro.model.Role;
import com.soft1851.springboot.shiro.model.User;
import com.soft1851.springboot.shiro.service.PermissionService;
import com.soft1851.springboot.shiro.service.RoleService;
import com.soft1851.springboot.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName AuthRealm
 * @Description 权限信息验证AuthRealm
 * @Author 田震
 * @Date 2020/5/21
 **/
public class AuthRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户Id查询角色信息
        List<Role> roleList = roleService.findRoleByUserId(user.getId());
        Set<String> roleSet = new HashSet<>();
        List<Integer> roleIds = new ArrayList<>();
        for (Role role : roleList) {
            roleSet.add(role.getRole());
            roleIds.add(role.getId());
        }
        // 放入角色信息
        authorizationInfo.setRoles(roleSet);
        // 放入权限信息
        List<String> permissionList = permissionService.findByRoleId(roleIds);
        authorizationInfo.setStringPermissions(new HashSet<>(permissionList));

        return authorizationInfo;
    }

    /**
     * 认证
     * @param authToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        // 根据用户名查询用户信息
        User user = userService.findByAccount(token.getUsername());
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}