package com.soft1851.springboot.task.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName Task2
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
@Component
public class Task2 {
    private DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    /**
     * fixedRate：固定频率执行
     */
    @Scheduled(fixedRate = 3000)
    public  void  reportCurrentTime1(){
        System.out.println(Thread.currentThread().getName()+"现在时间是："+dtf.format(LocalDateTime.now()));
    }

    /**
     * fixedDelay：固定延时
     */
    @Scheduled(fixedDelay = 2000)
    public  void  reportCurrentTime2(){
        System.out.println(Thread.currentThread().getName()+"现在时间是："+dtf.format(LocalDateTime.now()));
    }

    /**
     * 第一次延迟3秒后执行，之后按照fixedDelay的规则每2秒执行一次
     */
    @Scheduled(initialDelay = 3000,fixedDelay = 2000)
    public  void  reportCurrentTime3(){
        System.out.println(Thread.currentThread().getName()+"现在时间是："+dtf.format(LocalDateTime.now()));
    }
}