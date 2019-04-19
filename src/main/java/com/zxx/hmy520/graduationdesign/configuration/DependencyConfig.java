package com.zxx.hmy520.graduationdesign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;

/**
 * @auther: kam
 * @date: 14:58 2019-04-18
 * @description: 容错 缺失依赖注入
 */
@Configuration
public class DependencyConfig {

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer(){
        return new DefaultServerCodecConfigurer();
    }

}
