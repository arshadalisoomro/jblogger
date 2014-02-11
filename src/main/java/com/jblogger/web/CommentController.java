package com.jblogger.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@RequestMapping(value="/posts/{postId}/comments", method=RequestMethod.POST)
	public String create(@PathVariable("postId") Long postId, @Valid Comment comment, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors());
			return "comment.new";
		}
		
		postService.addCommentToPost(postId, comment);
		return "redirect:/posts/" + postId;
	}
	
	@RequestMapping(value="/posts/{postId}/comments/{commentId}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId, Model model) {
		Comment comment = commentService.getComment(commentId);
		Post post = postService.getPost(postId);
		model.addAttribute("comment", comment);
		model.addAttribute("post", post);
		return "comment.edit";
	}
	
	@RequestMapping(value="/posts/{postId}/comments/{commentId}", method=RequestMethod.PUT)
	public String update(@Valid Comment comment, BindingResult result, @PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors());
			return "comment.edit";
		}
		
		commentService.updateComment(comment);
		return "redirect:/posts/" + postId;
		
	}
}
