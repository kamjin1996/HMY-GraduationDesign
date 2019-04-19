package com.zxx.hmy520.graduationdesign.configuration;

import com.zxx.hmy520.graduationdesign.base.exception.handler.RestNotFoundController;
import com.zxx.hmy520.graduationdesign.base.exception.handler.WebSecurityExceptionHandlerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kam
 * @Description: 全局基础配置bean
 * @date 2018/5/8 13:32
 */
@Slf4j
@Configuration
public class CommonHandlerConfig {

    @Bean
    @ConditionalOnClass(WebSecurityExceptionHandlerAdvice.class)
    public WebSecurityExceptionHandlerAdvice webSecurityExceptionHandlerAdvice() {
        return new WebSecurityExceptionHandlerAdvice();
    }

    @Bean
    @ConditionalOnClass(RestNotFoundController.class)
    public RestNotFoundController restNotFoundController() {
        return new RestNotFoundController();
    }

    @Bean
    @ConditionalOnClass(CorsConfig.class)
    public CorsConfig corsConfig() {
        return new CorsConfig();
    }
}
