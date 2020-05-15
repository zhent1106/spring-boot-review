package com.soft1851.springboot.task.task;

import com.soft1851.springboot.task.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName AutoTask
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/15
 **/
@Slf4j
@Component
@Configuration
public class AutoTask  implements SchedulingConfigurer {
    @Resource
    private CronRepository cronRepository;
    private  String newCron ="0/5 * * * * ?";
    private  Integer cronId=1;

    @Bean()
    public Executor setTaskExecutors(){
        //创建一个基本的大小为3的线程池
        return Executors.newScheduledThreadPool(3);
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
     scheduledTaskRegistrar.addTriggerTask(()-> {
                 String cron = cronRepository.findCronByCronIdEquals(cronId).getCron();
                 //定时任务内容
                 log.info("当前时间：" + LocalDateTime.now());
                 if (!cron.equals(newCron)) {
                     log.info("定时任务参数修改");
                     cronRepository.updateCron(newCron, cronId);
                 }
             },
        triggerContext->{
             return  new CronTrigger(newCron).nextExecutionTime(triggerContext);
        }
     );

    }
}