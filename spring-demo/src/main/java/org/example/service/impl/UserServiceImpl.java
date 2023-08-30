package org.example.service.impl;

import org.example.service.UserService;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-30
 * @DOC 30
 */

public class UserServiceImpl implements UserService {
	 /**
	  * 吃
	  *
	  * @param clazzName clazz名字
	  * @return
	  */
	 @Override
	 public void toEat(String clazzName) throws ClassNotFoundException {
		  Class<?> clazz = Class.forName(clazzName);
		  System.out.println(clazz.getName());
	 }
}
