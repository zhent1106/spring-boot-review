package com.soft1851.springboot.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 田震
 * @version 1.0
 * @ClassName SpringWebController
 * @Description TODO
 * @date 2020-05-11 20:39
 **/
@Controller
@RequestMapping("/springWeb")
@ResponseBody
public class SpringWebController {
    @RequestMapping("/hello")
    public String hello(){
        return "<h2>Hello, Spring Boot!<h2>";
    }
}
