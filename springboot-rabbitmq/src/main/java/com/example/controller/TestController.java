package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc TestController
 * @Author LiuYunLong
 */

@RestController
@RequestMapping("/test")
public class TestController {


	 @GetMapping
	 public String test(){
		  return "test ok!";
	 }
}
