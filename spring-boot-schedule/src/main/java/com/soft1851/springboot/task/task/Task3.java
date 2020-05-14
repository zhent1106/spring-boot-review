package com.soft1851.springboot.task.task;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @ClassName Task3
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
//@Component
public class Task3 {
    /**
     * fixedRate固定频率执行
     * @Scheduled(fixedRate = 6000)：上一次开始执行时间点之后 6 秒再执行。
     * @Scheduled(fixedDelay = 6000)：上一次执行完毕时间点之后 6 秒再执行。
     * @Scheduled(initialDelay=1000, fixedRate=6000)：第一次延迟 1 秒后执行，之后按 fixedRate 的规则每 6 秒执行一次。
     */
    @Scheduled(fixedRate = 1000)
    public void  timeFixedRate(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("(fixRate)现在时间:%s", LocalDateTime.now()));

    }
    /**
     * FixedDelay固定延时
     */
    @Scheduled(fixedDelay = 3000)
    public void  timeFixedDelay(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("(fixedDelay)现在时间:%s", LocalDateTime.now()));

    }
    /**
     * 第一次延迟3秒后执行，之后按照fixedDelay的规则每2秒执行一次
     */
    @Scheduled(initialDelay = 3000,fixedDelay = 2000)
    public void  timeInitDelay(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("(InitDelay)现在时间:%s", LocalDateTime.now()));

    }

}