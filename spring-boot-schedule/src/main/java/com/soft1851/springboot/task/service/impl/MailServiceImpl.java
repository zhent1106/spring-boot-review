package com.soft1851.springboot.task.service.impl;

import com.soft1851.springboot.task.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @ClassName MailServiceImpl
 * @Description 邮件发送异常处理
 * @Author 田震
 * @Date 2020/5/15
 **/
@Slf4j
@Service
@Component
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender mailSender;
    @Override
    public void sendSimpleTestMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setFrom(from);
        mailSender.send(mailMessage);
        log.info("文本邮件成功发送！to={}",to);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        try {
        MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        //true为html邮件
        messageHelper.setText(content,true);
       mailSender.send(message);
        log.info("【HTML邮件】成功发送！to={}",to);
        }catch (MessagingException e){
            log.error("发送附件邮件时发生异常！");
        }
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            //添加附件
            for (String filePath:fileArr){
                FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
                if (fileSystemResource.exists()){
                    String fileName=fileSystemResource.getFilename();
                    assert  fileName!=null;
                    messageHelper.addAttachment(fileName,fileSystemResource);
                }
            }
            mailSender.send(mimeMessage);
            log.info("【附件邮件】成功发送！to={}",to);
        }catch (MessagingException e){
            log.error("发送附件邮件时发生异常！");
        }
    }

    @Override
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
        MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content,true);
        //添加照片
        for (Map.Entry<String,String> entry:imgMap.entrySet()){
            FileSystemResource fileSystemResource=new FileSystemResource(new File(entry.getValue()));
            if (fileSystemResource.exists()){
                messageHelper.addInline(entry.getKey(),fileSystemResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("【图片邮件】成功发送！to={}",to);
        }catch (MessagingException e){
            log.error("发送附件邮件时发生异常！");
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content, String filePath) {
            MimeMessage message = mailSender.createMimeMessage();

            try {
                //true表示需要创建一个multipart message
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setFrom(from);
                helper.setTo(to);
                helper.setSubject(subject);
                helper.setText(content, true);

                // 判断是否带有附件
                if (filePath != null) {
                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                    helper.addAttachment(fileName, file);
                }

                mailSender.send(message);
                log.info("html邮件发送成功");
            } catch (MessagingException e) {
                log.error("发送html邮件时发生异常！", e);
            }
    }
}