package com.lhb.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author littlelee
 * @date 2021/3/11 23:10
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
