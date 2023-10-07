package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootRabbitmqTests {


	 @Resource
	 private RabbitTemplate rabbitTemplate;

	 /**
	  * 简单队列
	  */
	 @Test
	 void testQueue() {

		  rabbitTemplate.convertAndSend("simple.queue", "hello world2222!!!");


	 }

	 /**
	  * 广播队列
	  */
	 @Test
	 void testFanoutQueue() {

		  for (int i = 0; i < 50; i++) {
				rabbitTemplate.convertAndSend("fanout.lyl", null, "hello world" + i);
		  }


	 }

}
