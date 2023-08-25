package com.example.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 *
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-25
 * @DOC 系统用户
 * @date 2023/08/25 09:28:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
	 private Integer userId;

	 private String username;

	 @DateTimeFormat(pattern = "yyyy/MM/dd")
	 private Date birthday;
}
