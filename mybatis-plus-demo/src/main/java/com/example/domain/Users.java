package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author liuyunlong
 * @description users
 * @date 2023-09-24
 */
@TableName("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Users implements Serializable {

	 private static final long serialVersionUID = 1L;

	 @TableId(type = IdType.AUTO)
	 private Long id;

	 /**
	  * username
	  */
	 private String username;

	 /**
	  * email
	  */
	 private String email;

	 /**
	  * password
	  */
	 private String password;

	 /**
	  * full_name
	  */
	 private String fullName;

	 /**
	  * age
	  */
	 private Integer age;

	 /**
	  * gender
	  */
	 private String gender;

	 /**
	  * avatar
	  */
	 private String avatar;


	 /**
	  * 创建时间
	  */
	 @TableField(fill = FieldFill.INSERT)
	 private LocalDateTime createTime;

	 /**
	  * 更新时间
	  */
	 @TableField(fill = FieldFill.UPDATE)
	 private LocalDateTime updateTime;

}
