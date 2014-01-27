package com.jblogger.service;

import java.util.List;

import com.jblogger.model.Authority;
import com.jblogger.model.User;

public interface UserService {
	public User getUser(String login);
	public void createUser(User user);
	public void createUser(User user, Authority authority);
	public void deleteUser(User user);
	public List<User> listUsers();
}
