package com.soft1851.springboot.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName ExternalApiController
 * @Description 外部接口的URL路径以 /external/作为前缀
 * @Author 田震
 * @Date 2020/5/17
 **/
@Controller
public class ExternalApiController {
    @GetMapping("/external/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello stranger");
    }
}