package com.robin.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;

/**
 * 测试spring操作Redis流水线,测试10万条的读/写2个操作,测试结果消耗时间大约为1100毫秒到1300毫秒之间.
 */
public class RedisPipelinedTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        SessionCallback callback = (SessionCallback) (RedisOperations ops) -> {
            for (int i = 0; i < 100000; i++) {
                int j = i + 1;
                ops.boundValueOps("pipeline_key_" + j).set("pipeline_value_" + j);
                ops.boundValueOps("pipeline_key_" + j).get();
            }
            return null;
        };
        long start = System.currentTimeMillis();
        //执行Redis的流水线命令
        redisTemplate.executePipelined(callback);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
