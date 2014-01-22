package com.jblogger.service;

import com.jblogger.model.User;

public interface UserService {
	public User getUser(String login);
	public void createUser(User user, String role);
}
