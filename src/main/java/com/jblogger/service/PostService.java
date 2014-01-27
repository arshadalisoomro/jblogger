package com.jblogger.service;

import java.util.List;

import com.jblogger.dto.Pager;
import com.jblogger.model.Comment;
import com.jblogger.model.Post;

public interface PostService {
	public Post getPost(Long id);
	public void createPost(Post post);
	public void updatePost(Post post);
	public void deletePost(Post post);
	public List<Post> listPosts();
	public List<Post> sublistPosts(Integer firstResult, Integer maxResults);
	public Pager listPostsInReverseChronologicalOrder(Integer page);
	public void addCommentToPost(Long postId, Comment comment);
	public void addCommentToPost(Long postId, Comment comment, String username);
}
