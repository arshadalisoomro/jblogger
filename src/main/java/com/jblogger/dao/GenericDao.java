package com.jblogger.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDao<T, K extends Serializable> {
	public T find(K id);
	public void add(T entity);
	public void Update(T transientEntity);
	public void delete(T persistentEntity);
	public List<T> list();
	//protected List<T> findByCriteria(Criterion... criterion);
}
