package com.soft1851.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName WebSecurityConfig
 * @Description Security配置器
 * @Author 田震
 * @Date 2020/5/20
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        System.out.println("进入配置");
//        httpSecurity.httpBasic()
//                .and()
//                .authorizeRequests()    //授权配置
//                .anyRequest()   //所有请求
//                .authenticated();   //都需要认证
        httpSecurity.csrf().disable();
        //开启授权认证
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        /**
         * 表单登录方式
         */
        httpSecurity.formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");
       //登录成功后的处理
        httpSecurity.formLogin().successHandler(new LoginSuccessHandler());
//        //登录失败后的处理
//        httpSecurity.formLogin().successHandler(new LoginFailureHandler());
//        //登录过期后的处理
//        httpSecurity.formLogin().successHandler(new LoginExpireHandler());
//        //登录过期后的处理
//        httpSecurity.formLogin().successHandler(new AuthLimitHandler());
    }

    public class LoginSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().write("{\"code\":\"200\",\"msg\":\"登录成功\"}");
        }
    }
    public class LoginFailureHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().write("{\"code\":\"500\",\"msg\":\"登录失败\"}");
        }
    }
    public class LoginExpireHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().write("{\"code\":\"401\",\"msg\":\"登录过期或未登录\"}");
        }
    }
    public class AuthLimitHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().write("{\"code\":\"403\",\"msg\":\"权限不足\"}");
        }
    }
}