package com.lhb.community;

import com.lhb.community.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author littlelee
 * @date 2021/1/13 0:18
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTest {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text = "你是一个大傻*逼,瓜*皮哈哈哈";
        String filter = sensitiveFilter.filter(text);
        System.out.println(filter);
    }
}
