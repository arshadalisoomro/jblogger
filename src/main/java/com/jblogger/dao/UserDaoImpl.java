package com.jblogger.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblogger.model.User;

@Repository
public class UserDaoImpl extends GenericHibernateDao<User, String> implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = sessionFactory.getCurrentSession()
									.createQuery("from User u where u.login = :login");
		
		query.setParameter("login", login);
		userList = query.list();
		
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
