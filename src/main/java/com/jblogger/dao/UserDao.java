package com.jblogger.dao;

import com.jblogger.model.User;

public interface UserDao extends GenericDao<User, String> {
	public User getUser(String login);
	public void add(User user);
}
