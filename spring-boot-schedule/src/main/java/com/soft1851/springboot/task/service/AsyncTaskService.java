package com.soft1851.springboot.task.service;

import com.soft1851.springboot.task.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName AsyncTaskService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/16
 **/
@Service
@Slf4j
public class AsyncTaskService {
    @Resource
    FileUtil fileUtil;
//    @Async
//    public  void  asyncTask(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("处理数据中");
//    }
//

    @Async
    public void asyncTask() {
        log.info("=======================》》其他线程："+Thread.currentThread().getName());
        fileUtil.getMessage();
        log.info("上传成功");
    }
}