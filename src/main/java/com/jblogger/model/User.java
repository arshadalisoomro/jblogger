package com.jblogger.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String login;
	
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="user_roles",  
    	joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},  
    	inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}  
	)  
	private Role role;
	
	//@OneToMany(mappedBy="team", cascade=CascadeType.ALL)  
    //private Set<player> players;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Comment> comments = new HashSet<Comment>();
	
	public User() {}
	
	public User(String login, String password) {
		setLogin(login);
		setPassword(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ "]";
	}

	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
