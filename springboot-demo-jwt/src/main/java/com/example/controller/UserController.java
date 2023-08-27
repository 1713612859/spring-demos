package com.example.controller;

import com.example.domian.SysUser;
import com.example.model.AjaxResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.example.utils.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 *
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-24
 * @DOC 用户控制器
 * @date 2023/08/24 11:40:37
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {

	 /**
	  * 登录
	  *
	  * @param user 用户
	  * @return {@link AjaxResult}
	  */// 用户登陆
	 @PostMapping("/login")
	 public AjaxResult login(@RequestBody SysUser user) {
		  String token = JwtTokenUtils.createToken(user);
		  return AjaxResult.success(token);
	 }


	 /**
	  * 当前注册人
	  *
	  * @param request 请求
	  * @return {@link AjaxResult}
	  */
	 @GetMapping("/secure/getCurrentUserInfo")
	 public AjaxResult currentUser(HttpServletRequest request) {
		  String token = request.getHeader("Auth");
		  SysUser user = null;
		  System.out.println("token = " + token);
		  if (!StringUtils.isEmpty(token)) {
				user = JwtTokenUtils.getPayload(token);
		  }
		  return AjaxResult.success(user);
	 }
}
