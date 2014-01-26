package com.jblogger.dao;

import org.springframework.stereotype.Repository;

import com.jblogger.model.Authority;

@Repository
public class AuthorityDaoImpl extends GenericHibernateDao<Authority, Integer> implements AuthorityDao {

}
