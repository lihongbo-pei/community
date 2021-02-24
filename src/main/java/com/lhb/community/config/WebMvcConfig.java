package com.lhb.community.config;

import com.lhb.community.controller.interceptor.AlphaInterceptor;
import com.lhb.community.controller.interceptor.LoginRequiredInterceptor;
import com.lhb.community.controller.interceptor.LoginTicketInterceptor;
import com.lhb.community.controller.interceptor.MessageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author littlelee
 * @date 2020/12/19 15:34
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AlphaInterceptor alphaInterceptor;
    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;
    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;
    @Autowired
    private MessageInterceptor messageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(alphaInterceptor)
                .excludePathPatterns("/*.css","/*.js","/*.png","/*.jpg","/*.jpeg")
                .addPathPatterns("/register","/login");

        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/*.css","/*.js","/*.png","/*.jpg","/*.jpeg");
        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/*.css","/*.js","/*.png","/*.jpg","/*.jpeg");
        registry.addInterceptor(messageInterceptor)
                .excludePathPatterns("/*.css","/*.js","/*.png","/*.jpg","/*.jpeg");
    }
}