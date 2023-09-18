package com.example.controller;

import com.example.SpringbootRestartDemoApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CreateTime 2023-09-1717:16
 * @Desc RestartController
 * @Author LiuYunLong
 * @date 2023/09/18 11:45:44
 */
@RequestMapping("/api")
@RestController
public class RestartController {
	 /**
	  * 容器优雅重启：
	  * 实质性就是将容器重新实例化一遍；
	  */
	 @GetMapping("/restart")
	 public void restart() {
		  SpringbootRestartDemoApplication.restart();
	 }
}
