package com.example.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Desc RabbitMqListenner
 * @Author LiuYunLong
 */

@Component
public class RabbitMqListener1 {


	 /**
	  * 简单队列
	  * @param msg
	  */
	 @RabbitListener(queues = "simple.queue")
	 public void listenerSimple(String msg){

		  System.err.println("接收到了 [fanout.queue1] "+msg+" \t");
	 }

	 /**
	  * 广播队列
	  * @param msg
	  */
	 @RabbitListener(queues = "fanout.queue1")
	 public void listenerFanout1(String msg){

		  System.err.println("接收到了 [fanout.queue1] "+msg+" \t");
	 }



	 @RabbitListener(queues = "fanout.queue2")
	 public void listenerFanout2(String msg){

		  System.err.println("接收到了 [fanout.queue2] "+msg+" \t");
	 }


}
