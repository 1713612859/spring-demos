package com.example.domain;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-27
 * @DOC 27
 */
public class SysUser {

	 private Integer userId;

	 private String username;

	 private String password;

	 private String avatar;


	 public Integer getUserId() {
		  return userId;
	 }

	 public void setUserId(Integer userId) {
		  this.userId = userId;
	 }

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

	 public String getAvatar() {
		  return avatar;
	 }

	 public void setAvatar(String avatar) {
		  this.avatar = avatar;
	 }

	 public SysUser() {
	 }

	 public SysUser(Integer userId, String username, String password, String avatar) {
		  this.userId = userId;
		  this.username = username;
		  this.password = password;
		  this.avatar = avatar;
	 }
}
