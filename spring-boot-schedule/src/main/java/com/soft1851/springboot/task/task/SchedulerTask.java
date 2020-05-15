package com.soft1851.springboot.task.task;

import com.soft1851.springboot.task.model.User;
import com.soft1851.springboot.task.repository.UserRepository;
import com.soft1851.springboot.task.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SchedulerTask
 * @Description 定时发送邮件
 * @Author 田震
 * @Date 2020/5/15
 **/
//@Component
public class SchedulerTask {
    private int count=0;
    @Resource
    private UserRepository userRepository;
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;
    /**
     *
     */
    @Scheduled(cron="*/5 * * * * ?")
    private void process() throws MessagingException {
        List<User> userList = userRepository.findUsersByBirthday();
        for (User user : userList
        ) {
            //创建邮件字段
            Context context = new Context();
            context.setVariable("siteTitle", user.getUsername());
            context.setVariable("permalink", "");
            context.setVariable("title", "寄来的贺卡《生日快乐》");
            context.setVariable("author", "春风拂面，像你的温柔");
            context.setVariable("time", "给我最美好的惊喜，和永无止境的宠溺");
            context.setVariable("text", "流星带着祝福划过天宇，萤火虫带着祝福点亮黑夜，我的短信带着祝福穿透时空，虽然不在你身边，我一直把你惦念，衷心祝你生日快乐！");
            context.setVariable("ip", "");
            context.setVariable("mail", "");
            context.setVariable("status", "");
            context.setVariable("manage", "");

            String to = user.getMail();
            String subject = user.getUsername() + "寄来的贺卡《生日快乐》";
            // 将字段加载到页面模板中
            String emailContent = templateEngine.process("sendMail", context);
            String imgPath = "D:\\1.gif";
            Map<String, String> imgMap = new HashMap<>();
            //以键值对的形式存入
            imgMap.put("img01", imgPath);
            mailService.sendImgMail(to, subject, emailContent, imgMap);
        }
    }
}