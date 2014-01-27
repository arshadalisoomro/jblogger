package com.jblogger.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jblogger.web.helper.EntityGenerator;

@Controller
public class IndexController {

	@Autowired
	private EntityGenerator entityGenerator;
	
	@RequestMapping(value="/")
	public String home() {		
		return "home";
	}
	
	@RequestMapping(value="/reset-domain")
	public String resetDomain() {
		prepareFakeDomain();
		return "redirect:/";
	}
	
	@PostConstruct
	public void prepareFakeDomain() {
		entityGenerator.deleteDomain();
		entityGenerator.generateDomain();
	}
}
