package com.jblogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jblogger.dao.RoleDao;
import com.jblogger.dao.UserDao;
import com.jblogger.model.Role;
import com.jblogger.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public User getUser(String login) {
		return userDao.getUser(login);
	}

	@Override
	@Transactional
	public void createUser(User user, String roleName) {
		Role role = roleDao.findByRoleName(roleName);
		user.setRole(role);
		userDao.add(user);
	}

}
