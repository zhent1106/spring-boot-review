package com.soft1851.springboot.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @ClassName SecuredServerController
 * @Description HTTPS测试
 * @Author 田震
 * @Date 2020/5/12
 **/
@RestController
@Slf4j
public class SecuredServerController {
    @RequestMapping("/secured")
    public String secured() {
        log.info("Inside secured()");
        return "Hello user !!! : " + LocalDateTime.now();
    }
}