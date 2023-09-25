package com.example.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.server.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc WebSocketController
 * @Author LiuYunLong
 */

@RestController
@RequestMapping("/test")
public class WebSocketController {


	 @GetMapping
	 public JSONObject getWebSocket() {
		  JSONObject jsonObject = new JSONObject();
		  jsonObject.put("count", WebSocketServer.getOnlineCount());

		  jsonObject.put("map", WebSocketServer.getMap());
		  return jsonObject;
	 }

}
