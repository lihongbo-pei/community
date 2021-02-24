package com.lhb.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author littlelee
 * @date 2020/12/14 20:10
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public Producer kaptchaProducer(){
        Properties properties = new Properties();
        properties.setProperty("kpatcha.image.width","100");
        properties.setProperty("kpatcha.image.height","40");
        properties.setProperty("kpatcha.textproducer.font.size","32");
        properties.setProperty("kpatcha.textproducer.font.color","0,0,0");
        properties.setProperty("kpatcha.textproducer.char.string","0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        properties.setProperty("kpatcha.textproducer.char.length","4");
        properties.setProperty("kpatcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }

}
