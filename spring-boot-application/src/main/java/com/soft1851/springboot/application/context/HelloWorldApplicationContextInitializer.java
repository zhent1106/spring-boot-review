package com.soft1851.springboot.application.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @ClassName HelloWorldApplicationContextInitializer
 * @Description @description:应用上下文初始化
 * @Author 田震
 * @Date 2020/5/12
 **/

//启动顺序
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HelloWorldApplicationContextInitializer <C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C applicationContext) {
        log.info(">>>>>>>>>>>>>>>>>>>> 初始化applicationContext，ConfigurableApplicationContext.id = " + applicationContext.getId());
    }
}