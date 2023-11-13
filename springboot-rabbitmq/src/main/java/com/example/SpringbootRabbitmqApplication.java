package com.example;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * rabbitmq 启动类
 */
@SpringBootApplication

public class SpringbootRabbitmqApplication {

	 public static void main(String[] args) {
		  SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	 }


	 /**
	  * jackson 消息转换器
	  *
	  * @return MessageConverter
	  */
	 @Bean
	 public MessageConverter jackson2JsonMessageConverter() {
		  return new Jackson2JsonMessageConverter();
	 }

}
