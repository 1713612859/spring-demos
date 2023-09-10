package com.example.controller;

import com.example.domian.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.util.Date;

/**
 * @author LiuYunLong
 */
@RestController
@RequestMapping("/api/test/")
public class TestController {

	 @GetMapping("/ok")
	 public String ok() {
		  String property = System.getProperty("user.dir");
		  return "ok !"+ property;
	 }

	 @GetMapping("/sysUser")
	 public SysUser sysUser() {
		  return new SysUser(1L, "张三", "45645456", new Date(), new Date());
	 }

}
