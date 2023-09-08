package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 系统用户对象实体
 *
 * @author LiuYunLong
 * @date 2023/09/07 13:52:43
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@ToString
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

}
