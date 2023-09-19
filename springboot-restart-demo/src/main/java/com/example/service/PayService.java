package com.example.service;

/**
 * 支付服务单例
 *
 * @Desc PayService
 * @Author LiuYunLong
 * @date 2023/09/19 09:58:57
 */
public class PayService {

	 private static PayService payService = null;

	 public static PayService getInstance() {
		  if (payService == null) {
				synchronized (PayService.class) {
					 if (payService == null) {
						  payService = new PayService();
					 }
				}
		  }
		  return payService;
	 }

	 public void sayHello() throws NoSuchMethodException {
		  System.out.println(this.getClass().getMethod("sayHello").getName());
	 }


	 public static void main(String[] args) throws NoSuchMethodException {
		  PayService instance = PayService.getInstance();
		  PayService instance2 = PayService.getInstance();
		  PayService instance3 = PayService.getInstance();
		  PayService instance4 = PayService.getInstance();

		  System.out.println("instance = " + instance);
		  System.out.println("instance2 = " + instance2);
		  System.out.println("instance3 = " + instance3);
		  System.out.println("instance4 = " + instance4);

		  instance.sayHello();
	 }

}
