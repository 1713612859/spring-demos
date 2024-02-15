package org.example.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试线程池
 *
 * @Desc TestThreadPool
 * @Author LiuYunLong
 * @date 2024/02/15 15:25:14
 */
public class TestThreadPool {

	private static  final AtomicInteger ATOMIC_INTEGER=new AtomicInteger(0);

	 public static void main(String[] args) {

		  int corePoolSize=10;// 最大线程数
		  int maximumPoolSize=20; // 最大工作线程池数
		  int keepAliveTime=60; // 活跃
		  TimeUnit seconds = TimeUnit.SECONDS; // 秒
		  BlockingQueue queue=new LinkedBlockingQueue(); // 链表队列
		  ThreadFactory threadFactory=Executors.defaultThreadFactory(); // 使用默认队列执行
		  RejectedExecutionHandler rejectedExecutionHandler=new ThreadPoolExecutor.AbortPolicy(); //拒绝策略 抛出异常即可

		  ThreadPoolExecutor executor = new ThreadPoolExecutor(
					 corePoolSize,
					 maximumPoolSize,
					 keepAliveTime,
					 seconds,
					 queue,
					 threadFactory,
					 rejectedExecutionHandler
		  );

		  for (int i = 0; i < 100; i++) {
		  // 执行
				executor.submit(()->{
						  System.out.println("send email ::: "+ATOMIC_INTEGER.getAndIncrement()+" ::: "+Thread.currentThread().getName());
				});
		  }

	 }
}
