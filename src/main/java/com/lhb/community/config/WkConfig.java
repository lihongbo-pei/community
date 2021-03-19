package com.lhb.community.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * @author littlelee
 * @date 2021/3/14 18:10
 */
@Configuration
public class WkConfig {

    private static final Logger logger = LoggerFactory.getLogger(WkConfig.class);

    @Value("${d:/work/data/wk-images}")
    private String wkImageStorage;

    @PostConstruct
    public void init(){
        // 创建WK图片目录
        File file = new File(wkImageStorage);
        if (!file.exists()) {
            file.mkdir();
            logger.info("创建WK图片目录: " + wkImageStorage);
        }
    }

}
