package com.example.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Desc SysUser
 * @Author LiuYunLong
 */
public class SysUser implements Serializable {

	 private Long id;

	 private String username;

	 private String password;

	 private String desc;

	 private Date loginDate;

	 public SysUser() {
	 }

	 public SysUser(Long id, String username, String password, String desc, Date loginDate) {
		  this.id = id;
		  this.username = username;
		  this.password = password;
		  this.desc = desc;
		  this.loginDate = loginDate;
	 }

	 public Long getId() {
		  return id;
	 }

	 public void setId(Long id) {
		  this.id = id;
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

	 public String getDesc() {
		  return desc;
	 }

	 public void setDesc(String desc) {
		  this.desc = desc;
	 }

	 public Date getLoginDate() {
		  return loginDate;
	 }

	 public void setLoginDate(Date loginDate) {
		  this.loginDate = loginDate;
	 }


	 @Override
	 public String toString() {
		  return "SysUser[" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", desc='" + desc + '\'' + ", loginDate=" + loginDate + ']';
	 }
}
