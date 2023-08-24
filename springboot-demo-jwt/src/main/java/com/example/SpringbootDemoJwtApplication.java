package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.filter")
public class SpringbootDemoJwtApplication {

	 public static void main(String[] args) {
		  SpringApplication.run(SpringbootDemoJwtApplication.class, args);
	 }

}
