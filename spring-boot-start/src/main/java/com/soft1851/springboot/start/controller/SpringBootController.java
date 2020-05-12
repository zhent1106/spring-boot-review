package com.soft1851.springboot.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 田震
 * @version 1.0
 * @ClassName SpringBootController
 * @Description TODO
 * @date 2020-05-11 20:38
 **/
@RestController
@RequestMapping("/api")
public class SpringBootController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot!";
    }
}
