package com.jblogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jblogger.dao.PostDao;
import com.jblogger.dto.Pager;
import com.jblogger.model.Comment;
import com.jblogger.model.Post;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	private static final int POSTS_PER_PAGE = 10;
	
	private PostDao postDao;
	
	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Post getPost(Long id) {
		return postDao.findWithComments(id);
	}

	@Override
	public void createPost(Post post) {
		postDao.add(post);
	}

	@Override
	public void updatePost(Post post) {
		postDao.Update(post);
	}

	@Override
	public void deletePost(Post post) {
		postDao.delete(post);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Post> listPosts() {
		return postDao.list();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Post> sublistPosts(Integer firstResult, Integer maxResults) {
		return postDao.sublist(firstResult, maxResults);
	}

	@Override
	public Pager listPostsInReverseChronologicalOrder(Integer page) {
		
		// First get the number of posts in the system
		int postCount = postDao.count();
		
		// Now work out how many posts should show per page
		int numPages = (int) Math.ceil((double) postCount / POSTS_PER_PAGE);
		
		// Set to first page if no page was supplied or it was a higher number than the available pages (starting at 1)
		// @todo throw a page not found exception or similar
		if (page == null || page > numPages) {
			page = 1;
		}

		// Post list will start at index 1 so we take that into account by adjusting (-1)
		int postStartIndex = (page - 1) * POSTS_PER_PAGE;
		
		return new Pager(
			page + 1 <= numPages ? page + 1 : null,
			page - 1 > 0 ? page - 1 : null,
			postDao.sublist(postStartIndex, POSTS_PER_PAGE)
		);
	}
	
	public void addCommentToPost(Long postId, Comment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		comment.setUsername(user.getUsername());
		Post post = getPost(postId);
		post.addComment(comment);
	}
	
	public void addCommentToPost(Long postId, Comment comment, String username) {
		comment.setUsername(username);
		Post post = getPost(postId);
		post.addComment(comment);
	}
	
}
