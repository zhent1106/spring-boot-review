package com.soft1851.springboot.rabbitmq.rabbit.book;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/18
 **/
@Service
public class BookService {
    //监听消息队列
    @RabbitListener(queues = "soft1851.news")
    public void receive(Book book) {
        System.out.println("************************");
        System.out.println("收到消息");
        System.out.println(book);
        System.out.println("************************");
    }

    @RabbitListener(queues = "soft1851")
    public void receive02(Message message) {
        System.out.println("===================");
        System.out.println("收到消息");
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
        System.out.println("===================");
    }
}