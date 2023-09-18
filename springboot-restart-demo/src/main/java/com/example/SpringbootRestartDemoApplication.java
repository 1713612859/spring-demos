package com.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/***
 * 	http://blog.gtiwari333.com/2021/04/spring-boot-shutdown-and-restart.html
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootRestartDemoApplication {

	 private static ConfigurableApplicationContext context;

	 public static void main(String[] args) {
		  context = SpringApplication.run(SpringbootRestartDemoApplication.class, args);
	 }


	 /**
	  * 重新启动
	  */
	 public static void restart() {
		  ApplicationArguments args = context.getBean(ApplicationArguments.class);

		  Thread thread = new Thread(() -> {
				context.close();
				context = SpringApplication.run(SpringbootRestartDemoApplication.class, args.getSourceArgs());
		  });

		  thread.setDaemon(false); // 不标记守护线程
		  thread.start();

	 }
}
