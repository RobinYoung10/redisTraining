package com.robin.service.impl.test;

import com.robin.domain.Role;
import com.robin.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试RoleService,即测试spring缓存注解
 */
public class RoleServiceTest {
    public static final Logger logger = Logger.getLogger(RoleServiceTest.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RoleService roleService = (RoleService) applicationContext.getBean("roleService");
        Role role = new Role();
        role.setRoleName("role_name_1");
        role.setNote("role_note_1");
        //插入角色
        //roleService.insertRole(role);
        //获取角色
        Role getRole = roleService.getRole(4L);
        getRole.setNote("role_note_1_update");
        //更新角色
        roleService.updateRole(getRole);
        //删除角色
        //roleService.deleteRole(getRole.getId());
    }
}
