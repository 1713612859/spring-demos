package com.example.service;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 支付服务单例
 *
 * @Desc PayService
 * @Author LiuYunLong
 * @date 2023/09/19 09:58:57
 */
@Service
public class PayService  implements InitializingBean {

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

	 /**
	  * Invoked by the containing {@code BeanFactory} after it has set all bean properties
	  * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
	  * <p>This method allows the bean instance to perform validation of its overall
	  * configuration and final initialization when all bean properties have been set.
	  *
	  * @throws Exception in the event of misconfiguration (such as failure to set an
	  *                   essential property) or if initialization fails for any other reason
	  */
	 @Override
	 public void afterPropertiesSet() throws Exception {
		  System.out.println("PayService");
	 }
}
