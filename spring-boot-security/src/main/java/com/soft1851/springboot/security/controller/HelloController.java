package com.soft1851.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Description 欢迎页面
 * @Author 田震
 * @Date 2020/5/20
 **/
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringSecurity";
    }
}