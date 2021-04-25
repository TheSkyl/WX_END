package com.wx.lib;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer   //此注解表示这是一个资源服务
@ComponentScan("com.wx.*")
public class LibApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibApplication.class, args);
    }
}
