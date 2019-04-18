package com.zxx.hmy520.graduationdesign.configuration;


import com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.annotation.IgnoreProperties;
import com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.annotation.JacksonFilterConfig;
import com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.impl.FilterPropertyHandler;
import com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.impl.JavassistFilterPropertyHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class IgnorePropertyConfig {
    /**
     * jack json 过滤
     *
     * @return
     */
    @Bean
    @ConditionalOnClass(JacksonFilterConfig.class)
    public JacksonFilterConfig JacksonFilterConfig() {
        return new JacksonFilterConfig();
    }

    public IgnorePropertyConfig() {
    }

    @Pointcut("@annotation(com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.annotation.IgnoreProperties)")
    private void anyMethod() {
    }

    @Around("anyMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object returnVal = pjp.proceed(); // 返回源结果
        try {
            FilterPropertyHandler filterPropertyHandler = new JavassistFilterPropertyHandler(true);
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            // 方法标注过滤的才进行过滤
            if (method.isAnnotationPresent(IgnoreProperties.class)) {
                returnVal = filterPropertyHandler.filterProperties(method, returnVal);
            }
        } catch (Exception e) {
            log.error("【JSON FILTER 错误】filter json error.", e);
        }
        return returnVal;
    }








}