package com.soft1851.springboot.shiro.controller;

import com.soft1851.springboot.shiro.config.ResponseCode;
import com.soft1851.springboot.shiro.config.StatusEnums;
import com.soft1851.springboot.shiro.model.User;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import static org.apache.shiro.SecurityUtils.getSubject;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
@RestController
public class LoginController {
    /**
     * 登录操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseCode login(@RequestBody User user) {
        //getSubject();这个方法就很熟悉了，就是我们在shiro中得到当前用户的方法
        Subject userSubject = getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        try {
            // 登录验证
            userSubject.login(token);
            return ResponseCode.success();
        } catch (UnknownAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }
    }


    @GetMapping("/login")
    public ResponseCode login() {
        return ResponseCode.error(StatusEnums.NOT_LOGIN_IN);
    }

    @GetMapping("/auth")
    public String auth() {
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public String role() {
        return "测试Vip角色";
    }

    @GetMapping("/permission")
    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
    public String permission() {
        return "测试Add和Update权限";
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public ResponseCode logout() {
        getSubject().logout();
        return ResponseCode.success();
    }
}