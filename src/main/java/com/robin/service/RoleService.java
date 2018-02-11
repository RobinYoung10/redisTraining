package com.robin.service;

import com.robin.domain.Role;

import java.util.List;

public interface RoleService {
    public Role getRole(Long id);
    public int deleteRole(Long id);
    public Role insertRole(Role role);
    public Role updateRole(Role role);
    public List<Role> findRoles(String roleName, String note);
}
