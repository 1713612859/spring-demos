//package com.example.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//
//import java.io.IOException;
//
///**
// * @author LiuYunLong
// */
//
//@Configuration
//public class ExternalConfig {
//
//
//	 private final String configFileName = "zhlk.properties";
//
//
//	 @Bean
//	 public PropertySourcesPlaceholderConfigurer externalProperties() throws IOException {
//
//		  PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
//		  Resource resource;
//		  resource = new FileSystemResource(configFileName);
//		  if (resource.exists()) {
//				System.out.println("current properties is exists {} ,name is {}" + resource.exists() + configFileName + "\t" + resource.getURL());
//				pspc.setLocations(resource);
//		  }
//		  else {
//				System.out.println("set internalProperties name is {} " + "application.properties");
//				resource = new ClassPathResource("application.properties");
//				pspc.setLocations(resource);
//		  }
//		  return pspc;
//	 }
//}
