package com.jblogger.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_roles",   
        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},  
        inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}  
    ) 
	private Set<User> userRoles;
	
	public Role() {}
	
	public Role(String role) {
		setRole(role);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", userRoles=" + userRoles
				+ "]";
	}
	
	
}
