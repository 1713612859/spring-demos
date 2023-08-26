package com.example;

import com.example.service.SysUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemoJedisApplication {

	 public static void main(String[] args) {
		  ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoJedisApplication.class, args);

		  SysUserService userService = context.getBean(SysUserService.class);

		  userService.sayHello("userService");


	 }

}
