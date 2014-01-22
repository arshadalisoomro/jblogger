package com.jblogger.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDao<T, K extends Serializable> implements GenericDao<T, K> {

	private Class<T> type;
	
	private SessionFactory sessionFactory;
	
	public GenericHibernateDao() {  
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
     }
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T find(K id) {
		return (T) currentSession().get(type, id);
	}

	@Override
	public void add(T entity) {
		currentSession().save(entity);
	}

	@Override
	public void Update(T transientEntity) {
		currentSession().update(transientEntity);
	}

	@Override
	public void delete(T persistentEntity) {
		currentSession().delete(persistentEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return currentSession().createCriteria(type).list();
	}
	
	/** 
     * Use this inside subclasses as a convenience method. 
     */  
    @SuppressWarnings("unchecked")  
    protected List<T> findByCriteria(Criterion... criterion) {  
        Criteria crit = currentSession().createCriteria(type);  
        for (Criterion c : criterion) {  
            crit.add(c);  
        }  
        return crit.list();  
   }
}
