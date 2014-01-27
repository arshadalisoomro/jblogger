package com.jblogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jblogger.dao.AuthorityDao;
import com.jblogger.dao.UserDao;
import com.jblogger.model.Authority;
import com.jblogger.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
	public User getUser(String login) {
		return userDao.getUser(login);
	}
	
	@Override
	@Transactional
	public void createUser(User user) {
		Authority authority = new Authority(user.getUsername(), Authority.USER);
		user.addAuthority(authority);
		userDao.add(user);
	}
	
	@Override
	@Transactional
	public void createUser(User user, Authority authority) {
		user.addAuthority(authority);
		userDao.add(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> listUsers() {
		return userDao.list();
	}

}
