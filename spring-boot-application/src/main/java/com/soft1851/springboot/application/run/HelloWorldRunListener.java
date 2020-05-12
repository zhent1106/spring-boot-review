package com.soft1851.springboot.application.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName HelloWorldRunListener
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/12
 **/
@Slf4j
public class HelloWorldRunListener implements SpringApplicationRunListener {
    public HelloWorldRunListener(SpringApplication application, String[] args) {
        log.info(">>>>>>>>>>>>>>>>>> 创建HelloWorldRunListener对象...");
    }

    @Override
    public void starting() {
        log.info(">>>>>>>>>>>>>>>>> HelloWorldRunListener.staring()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info(">>>>>>>>>>>>>>>> environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>>>> contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>> contextLoaded... ");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>> started...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>> running...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}