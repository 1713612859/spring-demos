package org.example;

import org.example.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-26
 * @DOC 26
 */
public class App {
	 public static void main(String[] args) {
		  Resource resource = new ClassPathResource("applicationContext.xml");
		  try {
				File file = resource.getFile();
				//System.out.println(file);

				InputStream inputStream = resource.getInputStream();
				byte[] b = new byte[1024];
				while ((inputStream.read(b)) != -1) {
					 System.out.println(new String(b, Charset.forName("UTF-8")));
				}

				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource.getFilename());
				UserService userService = context.getBean(UserService.class);
				System.out.println("userService = " + userService);


				ServiceLoader<UserService> services = ServiceLoader.load(UserService.class);

				Iterator<UserService> iterator = services.iterator();
				while (iterator.hasNext()) {
					 UserService next = iterator.next();
					 next.toEat(next.getClass().getName());
				}
		  }
		  catch (IOException e) {
				throw new RuntimeException(e);
		  }
		  catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
		  }
	 }
}
