package com.soft1851.springboot.task.controller;

import com.soft1851.springboot.task.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName AsyncTaskController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/16
 **/
@RestController
@Slf4j
public class AsyncTaskController {
    @Resource
    private AsyncTaskService asyncTaskService;
    @RequestMapping("/asyncTask")
    public  String asyncTask(){
        asyncTaskService.asyncTask();
        return "异常任务测试...";
    }
}