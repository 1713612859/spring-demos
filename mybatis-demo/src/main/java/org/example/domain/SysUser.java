package org.example.domain;

import java.util.Date;

/**
 * 系统用户对象实体
 *
 * @author LiuYunLong
 * @date 2023/09/07 13:52:43
 */
public class SysUser {


	 /**
	  * 用户id
	  */
	 private Long userId;
	 /**
	  * 用户名
	  */
	 private String username;
	 /**
	  * 密码
	  */
	 private String password;
	 /**
	  * 创建日期
	  */
	 private Date createDate;
	 /**
	  * 登录日期
	  */
	 private Date expireDate;


	 public SysUser() {
	 }

	 public SysUser(Long userId, String username, String password, Date createDate, Date expireDate) {
		  this.userId = userId;
		  this.username = username;
		  this.password = password;
		  this.createDate = createDate;
		  this.expireDate = expireDate;
	 }

	 public Long getUserId() {
		  return userId;
	 }

	 public void setUserId(Long userId) {
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

	 public Date getCreateDate() {
		  return createDate;
	 }

	 public void setCreateDate(Date createDate) {
		  this.createDate = createDate;
	 }

	 public Date getExpireDate() {
		  return expireDate;
	 }

	 public void setExpireDate(Date expireDate) {
		  this.expireDate = expireDate;
	 }

	 @Override
	 public String toString() {
		  return "SysUser{" + "userId=" + userId + ", username='" + username + '\'' + ", password='" + password + '\'' + ", createDate=" + createDate + ", expireDate=" + expireDate + '}';
	 }
}
