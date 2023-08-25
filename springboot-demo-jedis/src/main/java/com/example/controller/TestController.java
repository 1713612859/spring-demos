package com.example.controller;

import com.example.model.AjaxResult;
import com.example.utils.JedisPoolConfigUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-25
 * @DOC 25
 */
@RestController
@RequestMapping("/test/redis")
public class TestController {

	 Jedis jedis = JedisPoolConfigUtils.getJedis();


	 /**
	  * 测试字符串
	  *
	  * @param text 文本
	  * @return {@link AjaxResult}
	  */
	 @GetMapping("/setString/{text}")
	 public AjaxResult setString(@PathVariable(value = "text") String text) {
		  jedis.set(text, text);
		  return AjaxResult.success(jedis.get(text));
	 }


	 @PostMapping("/setMap")
	 public AjaxResult setString(@RequestBody Map<String,String> map) {
		  jedis.hset("user-session:123", map);
		  return AjaxResult.success(jedis.hgetAll("user-session:123"));
	 }


}
