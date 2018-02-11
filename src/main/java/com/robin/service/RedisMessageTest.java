package com.robin.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 测试发布订阅
 */
public class RedisMessageTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        String channel = "chat";
        redisTemplate.convertAndSend(channel, "Are you crazy!!!");
    }
}
