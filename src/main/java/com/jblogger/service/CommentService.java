package com.jblogger.service;

import java.util.List;

import com.jblogger.model.Comment;

public interface CommentService {
	public Comment getComment(Long id);
	public void createComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(Comment comment);
	public List<Comment> listComments();
}
