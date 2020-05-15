package com.soft1851.springboot.task.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;
@SpringBootTest
class MailServiceTest {
@Resource
private  MailService mailService;
    @Test
    void sendSimpleTestMail() {
        String to="1299088269@qq.com";
        String  subject="SpringBoot发送简单的文本邮件";
        String content="<h3>第一封来自田震的简单文本邮件</h3>";
        mailService.sendSimpleTestMail(to,subject,content);
    }

    @Test
    void sendHtmlMail()  throws  Exception{
        String to="1299088269@qq.com";
        String  subject="SpringBoot发送HTML邮件";
        String content="<h3>第一封来自田震的HTML邮件</h3>";
        mailService.sendHtmlMail(to,subject,content);
    }

    @Test
    void sendAttachmentMail() throws MessagingException {
        String to="1299088269@qq.com";
        String  subject="SpringBoot发送附件邮件";
        String content="<h3>第一封来自田震的附件邮件</h3>";
        String filePath="D:\\pom.xml";
        mailService.sendAttachmentMail(to,subject,content,filePath,filePath);
    }

    @Test
    void sendImgMail() throws MessagingException {
        String to="1299088269@qq.com";
        String  subject="SpringBoot发送图片邮件";
        String content="<h3>第一封来自田震的图片邮件</h3></br><img src=\"cid:img01\"/>";
        String imgPath="D:\\1.jpg";
        Map<String,String> imgMap=new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }

}