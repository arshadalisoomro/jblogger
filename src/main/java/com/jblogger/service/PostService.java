package com.jblogger.service;

import java.util.List;

import com.jblogger.dto.Pager;
import com.jblogger.model.Post;

public interface PostService {
	public Post getPost(Long id);
	public void createPost(Post post);
	public void updatePost(Post post);
	public void deletePost(Long id);
	public List<Post> listPosts();
	public List<Post> sublistPosts(Integer firstResult, Integer maxResults);
	public Pager listPostsInReverseChronologicalOrder(Integer page);
}
