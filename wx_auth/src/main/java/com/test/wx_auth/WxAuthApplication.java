package com.test.wx_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test"})
@EnableSwagger2
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WxAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxAuthApplication.class, args);
	}

}
