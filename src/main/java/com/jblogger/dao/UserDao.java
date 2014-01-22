package com.jblogger.dao;

import com.jblogger.model.User;

public interface UserDao {
	public User getUser(String login);
	public void add(User user);
}
