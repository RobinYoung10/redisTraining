package com.robin.dao;

import com.robin.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层接口,用于映射mybatis映射文件
 */
public interface RoleDao {
    public Role getRole(Long id);
    public int deleteRole(Long id);
    public int insertRole(Role role);
    public int updateRole(Role role);
    public List<Role> findRoles(@Param("roleName") String roleName, @Param("note") String note);
}
