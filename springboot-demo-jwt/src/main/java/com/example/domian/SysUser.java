package com.example.domian;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-24
 * @DOC 系统用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 private Date createDate;
	 /**
	  * 登录日期
	  */
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 private Date LoginDate;

}
