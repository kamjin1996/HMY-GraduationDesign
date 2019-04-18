package com.zxx.hmy520.graduationdesign.configuration.crosconfig;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @auther: kam
 * @date: 11:28 2019-04-18
 * @description: 跨域
 */
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
                .allowedMethods(
                        RequestMethod.GET.name(),
                        RequestMethod.POST.name(),
                        RequestMethod.DELETE.name(),
                        RequestMethod.PUT.name(),
                        RequestMethod.OPTIONS.name())
                .allowedHeaders("X-frame-options", "*")
                .maxAge(60000);
    }
}
