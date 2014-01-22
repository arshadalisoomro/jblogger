package com.jblogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jblogger.dao.RoleDao;
import com.jblogger.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRole(int id) {
		return roleDao.getRole(id);
	}

	@Override
	public void createRole(Role role) {
		roleDao.add(role);
	}

}
