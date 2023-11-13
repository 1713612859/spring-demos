package com.example.listeners;

import com.example.domain.SysUser;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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



	 @RabbitListener(queues = "json.queue")
//	 @RabbitListener(bindings = @QueueBinding(
//				value = @Queue(value = "json.queue",durable = "true"),
//				exchange = @Exchange(value = "json.lyl",type = ExchangeTypes.TOPIC),
//				key = "json")
//	 )
	 public void listenerJsonQueue(SysUser sysUser){

		  System.err.println("接收到了 [json.queue] "+sysUser+" \t");
	 }

}
