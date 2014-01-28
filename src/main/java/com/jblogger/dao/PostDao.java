package com.jblogger.dao;

import java.util.List;

import com.jblogger.model.Post;

public interface PostDao extends GenericDao<Post, Long> {
	public List<Post> sublist(Integer firstResult, Integer maxResults);
	public Post findWithComments(Long id);
	public int count();
}
