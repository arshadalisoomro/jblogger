package com.jblogger.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jblogger.service.PostService;

@ControllerAdvice
public class GlobalControllerAdvice {

	private PostService postService;
	
	@Autowired
	public GlobalControllerAdvice(PostService postService) {
		this.postService = postService;
	}
	
	@ModelAttribute
	public void recentPosts(Model model) {
		model.addAttribute("recentPosts", postService.sublistPosts(0, 5));
	}
}
