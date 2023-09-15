package org.example.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @CreateTime 10:50
 * @Desc LinkQueueTest 链表队列测试
 * @Author LiuYunLong
 */
public class LinkQueueTest {

	 public static void main(String[] args) {
		  /**
			* 阻塞队列：
			*/
		  BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		  queue.add(1);
		  queue.add(2);
		  queue.add(3);
		  queue.add(4);
		  // 检索队列，如果队列为空 返回 NULL , 不为NULL 返回头元素，但不移除
		  System.out.println(queue.peek());

		  queue.poll(); // 移除头元素
		  queue.add(5);


		  queue.forEach(ele -> System.out.println("ele = " + ele));
	 }
}
