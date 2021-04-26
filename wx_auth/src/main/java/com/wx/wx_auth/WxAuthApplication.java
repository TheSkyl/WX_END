package com.wx.wx_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wx.*")
public class WxAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxAuthApplication.class, args);
	}

}
