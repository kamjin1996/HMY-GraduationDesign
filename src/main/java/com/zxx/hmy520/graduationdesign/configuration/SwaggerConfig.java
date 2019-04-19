package com.zxx.hmy520.graduationdesign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author: kam
 * @date: 11:06 2019-04-19
 * @description: Swagger配置
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zxx.hmy520.graduationdesign.controller.open.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("open-API文档")
                .description("简单优雅的restful风格，https://blog.csdn.net/zx156955")
                //.termsOfServiceUrl("https://blog.csdn.net/zx156955")
                .contact(new Contact("kam","https://blog.csdn.net/zx156955","kamjin1996@163.com"))
                .version("1.0")
                .build();
    }
}
