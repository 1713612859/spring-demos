package org.example;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYunLong
 */
public class TreadLocalTest<T extends Object> {

	 /**
	  * ThreadLocal 保证每一个线程访问的数据都是独立的 但是需要及时remove 否则会引起内存溢出，
	  * 因为当你使用了，不移除时但是保存在ThreadLocalMap 里面 然后后续每一个线程访问的值都在此映射表里面 值爆炸
	  */
	 private static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

	 public static void main(String[] args) {
		  TreadLocalTest.setValue(5);

		  Integer value = (Integer) TreadLocalTest.getValue();
		  System.out.println("value = " + value);

		  new Thread(() -> {
				System.out.println(TreadLocalTest.getValue());
		  }).start();

		  new Thread(() -> {
				System.out.println(TreadLocalTest.getValue());
		  }).start();

		  ThreadPoolExecutor executor = executor();
		  executor.submit(() -> {
				TreadLocalTest.setValue("pool - test");

				System.out.println(TreadLocalTest.getValue());
		  });

	 }


	 public static <T extends Object> void setValue(T t) {
		  System.out.println("当前线程为 setValue()" + Thread.currentThread().getName());
		  threadLocal.set(t);
	 }


	 public static Object getValue() {
		  System.out.println("当前线程为 getValue()" + Thread.currentThread().getName());
		  return threadLocal.get();
	 }


	 public static ThreadPoolExecutor executor() {
		  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 2000, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2000));
		  threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		  return threadPoolExecutor;
	 }
}
