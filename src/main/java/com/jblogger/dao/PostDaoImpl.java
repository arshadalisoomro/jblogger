package com.jblogger.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.hql.internal.ast.tree.OrderByClause;
import org.springframework.stereotype.Repository;

import com.jblogger.model.Post;

@Repository
public class PostDaoImpl extends GenericHibernateDao<Post, Long> implements PostDao {

	/**
	 * @todo DRY this up!!! Call it sublist or something like that
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> sublist(Integer firstResult, Integer maxResults) {
		return currentSession().createCriteria(Post.class)
							   .addOrder(Order.desc("published"))
							   .setFirstResult(firstResult)
							   .setMaxResults(maxResults)
							   .list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> reverseChronologicalOrder(int index, int numResults) {
		Criteria criteria = currentSession().createCriteria(Post.class);
		criteria.addOrder(Order.desc("published"));
		criteria.setFirstResult(index);
		criteria.setMaxResults(numResults);
		return criteria.list();
	}

	@Override
	public int count() {
		return ((Long)currentSession().createQuery("select count(*) from Post").uniqueResult()).intValue();
	}

	@Override
	public Post findWithComments(Long id) {
		// TODO Auto-generated method stub
		Post post = (Post) currentSession().createQuery("from Post as post left join fetch post.comments where post.id = :id")
										   .setParameter("id", id)
										   .uniqueResult();
		return post;
	}
}
