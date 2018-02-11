package com.robin.service;

import com.robin.domain.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

/**
 * 测试RedisTemplate
 */
public class RedisTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        final Role role = new Role();
        role.setId(1L);
        role.setRoleName("name_1");
        role.setNote("note_1");
        SessionCallback callback = new SessionCallback<Role>() {
            public Role execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.boundValueOps("role_1").set(role);
                return (Role) redisOperations.boundValueOps("role_1").get();
            }
        };
        Role savedRole = (Role) redisTemplate.execute(callback);
        System.out.println(savedRole.getRoleName());
    }
}
