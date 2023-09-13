package com.example.controller;

import com.example.domian.SysUser;
import com.example.utils.PathUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Properties;

/**
 * @author LiuYunLong
 */
@RestController
@RequestMapping("/api/test/")
public class TestController {

	 @GetMapping("/ok")
	 public String ok() {
		  String jarPath = PathUtil.getJarPath();
		  findExartProperties(jarPath);


		  return "ok !   " + jarPath + " \t";
	 }

	 /**
	  * 找外部文件
	  *
	  * @param jarPath
	  */
	 private Properties findExartProperties(String jarPath) {
		  Properties pro = new Properties();
		  File file = new File(jarPath + "\\" + "zhlk.properties");
		  if (file.exists()) {
				try {
					 pro.load(new InputStreamReader(new FileInputStream(file), Charset.defaultCharset()));
					 System.out.println("username" + pro.getProperty("username"));
					 System.out.println("userage" + pro.getProperty("userage"));
				}
				catch (IOException e) {
					 throw new RuntimeException(e);
				}
		  }
		  else {
				System.out.println("file not found");
		  }
		  return pro;
	 }

	 @GetMapping("/sysUser")
	 public SysUser sysUser() {
		  return new SysUser(1L, "张三", "45645456", new Date(), new Date());
	 }


}
