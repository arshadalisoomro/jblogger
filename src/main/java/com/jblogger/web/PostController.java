package com.jblogger.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jblogger.dto.Pager;
import com.jblogger.model.Post;
import com.jblogger.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public String index(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		Pager pager = postService.listPostsInReverseChronologicalOrder(page);
		model.addAttribute("pager", pager);
		return "post.index";
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Post post = postService.getPost(id);
		model.addAttribute("post", post);
		return "post.show";
	}
	
	@RequestMapping(value="/posts/new", method=RequestMethod.GET)
	public String newPost(Post post) {
		return "post.new";
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	public String create(@Valid Post post, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors());
			return "post.new";
		}
		
		// As the test data is being created to simulate the blog i'm just setting the 
		// date here rather than letting Hibernate do the job
		post.setPublished(new java.util.Date());
		postService.createPost(post);
		
		return "redirect:/posts/" + post.getId();
	}
	
	@RequestMapping(value="/posts/{id}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Post post = postService.getPost(id);
		model.addAttribute("post", post);
		return "post.edit";
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid Post post, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors());
			return "post.edit";
		}
		
		//post.setId(id);
		System.out.println(post);
		postService.updatePost(post);
		return "redirect:/posts/" + post.getId();
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		Post post = postService.getPost(id);
		postService.deletePost(post);
		return "redirect:/posts";
	}
}
