package com.jblogger.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblogger.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Role getRole(int id) {
		return (Role) sessionFactory.getCurrentSession().load(Role.class, id);
	}

	@Override
	public void add(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public Role findByRoleName(String name) {
		return (Role) sessionFactory.getCurrentSession()
					  				.createQuery("from Role where role = :name")
									.setParameter("name", name)
									.uniqueResult();
	}

}
