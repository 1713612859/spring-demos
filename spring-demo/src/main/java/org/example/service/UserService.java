package org.example.service;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-26
 * @DOC 26
 */
public class UserService {

	 private String name;

	 public UserService(String name) {
		  System.out.println("User-Service Inject" + name);
	 }
}
