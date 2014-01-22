package com.jblogger.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jblogger.model.Role;
import com.jblogger.model.User;
import com.jblogger.service.RoleService;
import com.jblogger.service.UserService;
import com.jblogger.web.helper.EntityGenerator;

@Controller
public class IndexController {

	@Autowired
	private EntityGenerator entityGenerator;
	
	@RequestMapping(value="/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/about")
	public String about() {
		return "about";
	}
	
	@PostConstruct
	public void prepareFakeDomain() {
		entityGenerator.deleteDomain();
		entityGenerator.generateDomain();
	}
}
