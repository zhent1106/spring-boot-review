package com.soft1851.springboot.task.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @ClassName TestAsyncBean
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/16
 **/
@Component
public class TestAsyncBean {
    @Async
    public Future<String> sayHello1() throws InterruptedException {
        int thinking = 2;
        Thread.sleep(thinking * 1000);//网络连接中 。。。消息发送中。。。
        System.out.println("我爱你啊!");
        return new AsyncResult<String>("发送消息用了"+thinking+"秒");
    }
}