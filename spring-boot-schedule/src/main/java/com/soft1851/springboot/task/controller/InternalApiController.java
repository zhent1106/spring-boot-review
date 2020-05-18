package com.soft1851.springboot.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName InternalApiController
 * @Description 内部接口的URL路径以 /internal/作为前置
 * @Author 田震
 * @Date 2020/5/17
 **/
@Controller
public class InternalApiController {
    @GetMapping("/internal/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello friend");
    }
}