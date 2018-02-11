package com.robin.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;

/**
 * 测试Redis基础事务
 */
public class RedisMultiTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        SessionCallback callback = (SessionCallback) (RedisOperations ops) -> {
            ops.multi();
            ops.boundValueOps("key1").set("value1");
            String value = (String) ops.boundValueOps("key1").get();
            System.out.println("value = " + value);
            List list = ops.exec();
            value = (String) redisTemplate.opsForValue().get("key1");
            return list;
        };
        List list = (List) redisTemplate.execute(callback);
        System.out.println(list.get(0));
    }
}
