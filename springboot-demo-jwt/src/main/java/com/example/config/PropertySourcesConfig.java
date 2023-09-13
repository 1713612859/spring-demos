//package com.example.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
///**
// * @author LiuYunLong
// */
//@Configuration
//@Slf4j
//public class PropertySourcesConfig {
//
////	 private final String configFileName = "zhlk.properties";
//
//
////	 @Bean
////	 @ConditionalOnResource(resources = configFileName)
////	 public PropertySourcesPlaceholderConfigurer externalProperties() throws IOException {
////
////		  PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
////		  Resource resource = new FileSystemResource(configFileName);
////
////		  System.out.println("current properties is exists {} ,name is {}" + resource.exists() + configFileName + "\t" + resource.getURL());
////		  if (resource.exists()) {
////				pspc.setLocations(resource);
////		  }
////
////		  return pspc;
////	 }
//
//
//	 @Bean
//	 @ConditionalOnMissingBean(ExternalConfig.class)
//	 public PropertySourcesPlaceholderConfigurer internalProperties() {
//
//		  PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//
//		  Resource resource = new ClassPathResource("application.properties");
//		  configurer.setLocations(resource);
//
//		  System.out.println("set internalProperties name is {} " + "application.properties");
//		  return configurer;
//	 }
//}
