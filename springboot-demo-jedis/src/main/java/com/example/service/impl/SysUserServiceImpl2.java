package com.example.service.impl;

import com.example.service.SysUserService;
import org.springframework.stereotype.Component;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-25
 * @DOC 25
 */
//@Component
public class SysUserServiceImpl2 implements SysUserService {
	 @Override
	 public void sayHello(String username) {
		  System.out.println("username = " + username);
	 }
}
