package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

<<<<<<< HEAD
=======

>>>>>>> 3431474cdd97cde07b1aa08fe766e0124199e2e0
@Component
public class MailClient {

    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);

    @Autowired
    private JavaMailSender mailSender;

<<<<<<< HEAD
    @Value("${spring.mail.username}")   // 发件人
=======
    @Value("${spring.mail.username}")
>>>>>>> 3431474cdd97cde07b1aa08fe766e0124199e2e0
    private String from;

    public void sendMail(String to, String subject, String content){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);  // HTML文本
            mailSender.send(helper.getMimeMessage());
        }catch(MessagingException e){
            logger.error("发送邮件失败：" + e.getMessage());
        }

    }
    
}
