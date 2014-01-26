package com.jblogger.service;

import com.jblogger.model.Authority;
import com.jblogger.model.User;

public interface UserService {
	public User getUser(String login);
	public void createUser(User user);
	public void createUser(User user, Authority authority);
}
