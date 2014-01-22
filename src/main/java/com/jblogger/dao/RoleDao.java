package com.jblogger.dao;

import com.jblogger.model.Role;

public interface RoleDao {
	public Role getRole(int id);
	public Role findByRoleName(String name);
	public void add(Role role);
}
