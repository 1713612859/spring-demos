package com.example;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.example.domian.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootDemoJedisApplicationTests {

    @Test
    void testRedisConnect() {
        JedisPool pool = new JedisPool("localhost", 6379);
        try {
            Jedis jedis = pool.getResource();
            // Store & Retrieve a simple string
            jedis.set("foo", "bar");
            System.out.println(jedis.get("foo")); // prints bar

            // Store & Retrieve a HashMap
            Map<String, String> hash = new HashMap<>();

            hash.put("name", "John");
            hash.put("surname", "Smith");
            hash.put("company", "Redis");
            hash.put("age", "29");
            jedis.hset("user-session:123", hash);
            System.out.println(jedis.hgetAll("user-session:123"));
            // Prints: {name=John, surname=Smith, company=Redis, age=29}

            SysUser user = new SysUser(1, "张三", new Date());
            Object json = JSON.toJSON(user);
            jedis.set("sys_user:1", json.toString());

            String userInfo = jedis.get("sys_user:1");
            System.out.println("userInfo = " + userInfo);
            SysUser parse = JSON.parseObject(userInfo,SysUser.class);
            System.out.println("parse = " + parse);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
