package com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.annotation;

import com.zxx.hmy520.graduationdesign.configuration.JacksonFilter.impl.Jackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

public class JacksonFilterConfig extends WebMvcConfigurerAdapter {
    /**
     * 注入Jackson2HttpMessageConverter控制器
     *
     * @return
     */
    private MappingJackson2HttpMessageConverter jacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new Jackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        return converter;
    }

    /**
     * 添加控制器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(jacksonHttpMessageConverter());
    }

}
