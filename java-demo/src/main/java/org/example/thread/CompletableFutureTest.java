package org.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

/**
 * 异步编排任务测试
 * @CreateTime 22:38
 * @Desc test
 * @Author LiuYunLong
 */
public class CompletableFutureTest {

	 public static void main(String[] args) throws Exception {
		  System.out.println(System.currentTimeMillis());

		  /**
			* 异步编排任务 合并求和
			*/
		  CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
				try {
					 String str = null;
					 str.getBytes(); // 如果某一个发生异常 则导致所有异步任务全部失败
					 System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
					 sleep(5000);
				}
				catch (InterruptedException e) {
					 throw new RuntimeException(e);
				}
				return "hello ";
		  });
		  CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
				System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
				try {
					 sleep(5000);
				}
				catch (InterruptedException e) {
					 throw new RuntimeException(e);
				}
				return "Beautiful ";
		  });
		  CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World ");
		  /**
			* 得到异步编排的任务
			*/
//		  CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
		  /**
			* 随便一个结束 即可
			*/
		  CompletableFuture<Object> combinedFuture = CompletableFuture.anyOf(future1, future2, future3);

		  String res = new String();

		  // 返回结果
		  CompletableFuture<String> apply = combinedFuture.thenApply(unused -> {

				try {
					 return res + future1.get() + future2.get() + future3.get();
				}
				catch (InterruptedException e) {
					 throw new RuntimeException(e);
				}
				catch (ExecutionException e) {
					 throw new RuntimeException(e);
				}


		  });




		  long end = System.currentTimeMillis();
		  // 得到结果 但是结果最终是同步的
		  System.out.println("apply.get() = " + apply);
		  System.out.println(System.currentTimeMillis());

//		  1694790333019
//		  Thread.currentThread().getName() = ForkJoinPool.commonPool-worker-1
//		  Thread.currentThread().getName() = ForkJoinPool.commonPool-worker-2
//		  apply.get() = hello Beautiful World
//		  1694790338069

	 }
}
