package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
<<<<<<< HEAD
    private TemplateEngine templateEngine; // Thymeleaf核心类,生成动态网页

    @Test  // 发送文本邮件
=======
    private TemplateEngine templateEngine; // Thymeleaf核心类

    @Test
>>>>>>> 3431474cdd97cde07b1aa08fe766e0124199e2e0
    public void testTextMail(){
        mailClient.sendMail("xiaomengcd18@163.com","test","welcome!");
    }

<<<<<<< HEAD
    @Test  // 发送html邮件
    public void testHtmlMail(){
        Context context = new Context(); // thymeleaf
=======
    @Test
    public void testHtmlMail(){
        Context context = new Context();
>>>>>>> 3431474cdd97cde07b1aa08fe766e0124199e2e0
        context.setVariable("username","sunday");

        String content = templateEngine.process("/mail/demo",context);
        System.out.println(content);

        mailClient.sendMail("xiaomengcd18@163.com","HTML",content);
    }

}
