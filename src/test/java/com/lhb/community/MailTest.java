package com.lhb.community;

import com.lhb.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author littlelee
 * @date 2020/12/10 23:53
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.sendMail("822132397@qq.com","MUA","爱你杨鑫");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","aaa");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        mailClient.sendMail("1973742240@qq.com","HTML",content);
    }

}
