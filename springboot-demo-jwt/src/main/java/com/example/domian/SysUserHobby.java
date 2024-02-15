package com.example.domian;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Desc SysUserHobby
 * @Author LiuYunLong
 */

@Data
public class SysUserHobby {


	 @NotNull(message = "爱好不能为空")
	 private Integer hobbyId;


	 private String hobbyDesc;

}
