package com.example;

import com.example.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.filter")
@EnableConfigurationProperties
public class SpringbootDemoJwtApplication implements ApplicationRunner {

	 public static void main(String[] args) {
		  ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoJwtApplication.class, args);
		  ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		  LocalhostProperties properties = beanFactory.getBean(LocalhostProperties.class);

		  System.out.println(properties);
		  System.out.println(222 + properties.getUser());


	 }


	 @Autowired
	 private LocalhostProperties localhostProperties;

	 @Override
	 public void run(ApplicationArguments args) throws Exception {
		  String path = PathUtil.getJarPath();
		  Properties properties = PathUtil.findExartProperties(path);
		  if (!properties.isEmpty()) {
//				for (Object o : properties.keySet()) {
//					 System.out.println("o = " + o);
//					 if ()
//					 localhostProperties.setUser();
//				}
				localhostProperties.setUser(properties.getProperty("username", "localhost"));
		  }

		  System.out.println(localhostProperties.getUser());

	 }
}
