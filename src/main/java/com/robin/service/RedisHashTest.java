package com.robin.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试redis数据结构--哈希
 */
public class RedisHashTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        String key = "hash";
        Map<String, String> map = new HashMap<String, String>();
        map.put("f1", "val1");
        map.put("f2", "val2");
        //相当于hmset命令
        redisTemplate.opsForHash().putAll(key, map);
        //相当于hset命令
        redisTemplate.opsForHash().put(key, "f3", "6");
        printValueForHash(redisTemplate, key, "f3");
        //相当于hexists key filed命令
        boolean exists = redisTemplate.opsForHash().hasKey(key, "f3");
        System.out.println(exists);
        //相当于hgetall命令
        Map keyValMap = redisTemplate.opsForHash().entries(key);
        //相当于hincrby命令
        redisTemplate.opsForHash().increment(key, "f3", 0.88);
        printValueForHash(redisTemplate, key, "f3");
    }
    private static void printValueForHash(RedisTemplate redisTemplate, String key, String field) {
        //相当于hget命令
        Object value = redisTemplate.opsForHash().get(key, field);
        System.out.println(value);
    }
}
