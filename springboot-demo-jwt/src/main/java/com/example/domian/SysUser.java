package com.example.domian;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

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
	 @NotBlank(message = "用户名不能为空")
	 private String username;
	 /**
	  * 密码
	  */
	 @NotBlank(message = "密码不能为空")
	 @Length(min = 6, max = 12, message = "密码最短为6位，最大为12位")
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
	 private Date expireDate;


	 @NotEmpty(message = "爱好列表不能为空")
	 @Valid
	 private List<SysUserHobby> sysUserHobbies;

}
