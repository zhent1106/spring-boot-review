package com.soft1851.springboot.task.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@SpringBootTest
class TestAsyncBeanTest {
    @Autowired
    private TestAsyncBean testAsyncBean;
    @Test
    public void test_sayHello1() throws InterruptedException, ExecutionException {
        /**
         * 一个Future 对象用于表示 异步操作 的结果，这些正在处理的操作或 I/O 将会在稍后完成。
         */
        Future<String> future = null;
        System.out.println("你不爱我了么?");
        future = testAsyncBean.sayHello1();
        System.out.println("你竟无话可说, 我们分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
        System.out.println(future.get());
    }

}