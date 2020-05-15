package com.soft1851.springboot.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName ScheduleConfig
 * @Description 定时任务配置
 * @Author 田震
 * @Date 2020/5/14
 **/
//@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(setTaskExecutors());
    }
    @Bean()
    public Executor setTaskExecutors(){
        /**
         * 创建一个基本大小为3的线程池
         */
        return Executors.newScheduledThreadPool(3);
    }

}