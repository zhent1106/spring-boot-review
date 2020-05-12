package com.soft1851.springboot.application.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringApplicationEventBootstrap
 * @Description Spring 应用事件引导类
 * @Author 田震
 * @Date 2020/5/12
 **/
@SpringBootApplication
@Slf4j
public class SpringApplicationEventBootstrap {
    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            log.info("监听到事件: " + event);
        });

        // 启动上下文
        context.refresh();
        // 发送事件
        context.publishEvent("COVID-2019");
        context.publishEvent("2020");
        context.publishEvent(new ApplicationEvent("新冠肺炎") {

        });

        // 关闭上下文
        context.close();
    }
}