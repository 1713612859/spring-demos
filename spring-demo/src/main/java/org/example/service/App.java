package org.example.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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
		  }
		  catch (IOException e) {
				throw new RuntimeException(e);
		  }
	 }
}
