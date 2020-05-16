package com.soft1851.springboot.task;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @ClassName QuartzTest
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/16
 **/
public class QuartzTest {
    public static void main(String[] args) {
        try {
            //从工厂获取调度程序的实例
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
            //启动
            scheduler.start();
            //停止
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}