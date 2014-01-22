package com.jblogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Comment getComment(Long id) {
		return commentDao.find(id);
	}

	@Override
	public void createComment(Comment comment) {
		commentDao.add(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		commentDao.Update(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		commentDao.delete(comment);
	}

	@Override
	public List<Comment> listComments() {
		return commentDao.list();
	}

}
