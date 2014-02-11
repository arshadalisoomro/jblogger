package com.jblogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jblogger.dao.CommentDao;
import com.jblogger.model.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;
	
	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Comment getComment(Long id) {
		return commentDao.find(id);
	}

	@Override
	public void createComment(Comment comment) {
		commentDao.add(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		Comment persistentComment = commentDao.find(comment.getId());
		persistentComment.setBody(comment.getBody());
		commentDao.Update(persistentComment);
	}

	@Override
	public void deleteComment(Comment comment) {
		commentDao.delete(comment);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Comment> listComments() {
		return commentDao.list();
	}
	
	public boolean isCommentOwner(Comment comment) {
		
		return false;
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//User user = (User) auth.getPrincipal();
		//comment.setUsername(user.getUsername());
	}
}
