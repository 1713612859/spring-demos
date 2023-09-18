package com.example.domain.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Desc User
 * @Author LiuYunLong
 * @date 2023/09/18 16:45:32
 */
@Component
@ConfigurationProperties(prefix = "user")
public class SysUser {

	 private String username;
	 private String password;
	 private int age;

	 public String getUsername() {
		  return username;
	 }

	 public void setUsername(String username) {
		  this.username = username;
	 }

	 public String getPassword() {
		  return password;
	 }

	 public void setPassword(String password) {
		  this.password = password;
	 }

	 public int getAge() {
		  return age;
	 }

	 public void setAge(int age) {
		  this.age = age;
	 }
}
