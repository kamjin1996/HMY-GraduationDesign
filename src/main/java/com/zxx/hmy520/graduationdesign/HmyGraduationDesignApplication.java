package com.zxx.hmy520.graduationdesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableWebSecurity
@SpringBootApplication
public class HmyGraduationDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmyGraduationDesignApplication.class, args);
    }

}
