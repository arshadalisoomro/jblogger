package com.jblogger.dao;

import org.springframework.stereotype.Repository;

import com.jblogger.model.Comment;

@Repository
public class CommentDaoImpl extends GenericHibernateDao<Comment, Long> implements CommentDao {

}
