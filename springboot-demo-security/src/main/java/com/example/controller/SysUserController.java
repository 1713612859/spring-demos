package com.example.controller;

import com.example.domain.SysUser;
import com.example.model.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户控制器
 *
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-27
 * @DOC 系统用户控制器
 * @date 2023/08/27 11:46:08
 */

@RestController
@RequestMapping("/sys/users")
public class SysUserController {


	 private static List<SysUser> userList;
	 static {
			userList=new ArrayList<>();
			userList.add(new SysUser(1,"张三","123456","/com.example/1"));
			userList.add(new SysUser(2,"李四","123456","/com.example/2"));
			userList.add(new SysUser(3,"王五","123456","/com.example/3"));
	 }

	 /**
	  * default username is user
	  * default password on console
	  * @return
	  */
	 @GetMapping
	 public AjaxResult getUsers(){
		  return AjaxResult.success(userList);
	 }
}
