//package com.example.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
///**
// * @author LiuYunLong
// */
//@Configuration
//public class InternalConfig {
//	 @Bean
//	 @ConditionalOnMissingBean(ExternalConfig.class)
//	 @Order(value = 1)
//	 public PropertySourcesPlaceholderConfigurer internalProperties() {
//
//		  PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//
//		  Resource resource = new ClassPathResource("application.properties");
//		  configurer.setLocations(resource);
//
//
//
//		  System.out.println("set internalProperties name is {} " + "application.properties");
//		  return configurer;
//	 }
//}
