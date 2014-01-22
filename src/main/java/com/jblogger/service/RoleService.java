package com.jblogger.service;

import com.jblogger.model.Role;

public interface RoleService {
	public Role getRole(int id);
	public void createRole(Role role);
}
