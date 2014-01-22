package com.jblogger.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jblogger.model.Comment;
import com.jblogger.model.Post;
import com.jblogger.service.CommentService;
import com.jblogger.service.PostService;

@Controller
public class CommentController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/posts/{postId}/comments/new", method=RequestMethod.GET)
	public String newComment(@PathVariable("postId") Long postId, Comment comment, Model model) {
		Post post = postService.getPost(postId);
		model.addAttribute("post", post);
		return "comment.new";
	}
	
	@RequestMapping(value="/posts{id}/comments", method=RequestMethod.POST)
	public String create(@Valid Comment comment, BindingResult result) {
		return "something";
	}
}
