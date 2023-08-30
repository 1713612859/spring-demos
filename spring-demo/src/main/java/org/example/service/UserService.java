package org.example.service;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-26
 * @DOC 26
 */
public interface UserService {

	 /**
	  * 吃
	  *
	  * @param clazzName clazz名字
	  * @return
	  */
	 void toEat(String clazzName) throws ClassNotFoundException;
}
