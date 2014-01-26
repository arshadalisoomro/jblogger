package com.jblogger.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

import com.jblogger.model.Authority;


@Entity
@Table(name = "users")
public class User {

    private static final long serialVersionUID = -8275492272371421013L;

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
//    @NotNull
    private String password;

    @Column(name = "enabled", nullable = false)
//    @NotNull
    private Boolean enabled;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity=Authority.class)
    private Set<Authority> appAuthorities = new HashSet<Authority>();

    public User() {
    }
    
    public User(String username, String password) {
    	this.username = username;
    	this.password = password;
    	enabled = true;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAppAuthorities() {
		return appAuthorities;
	}

	public void setAppAuthorities(Set<Authority> appAuthorities) {
		this.appAuthorities = appAuthorities;
	}
	
	public void addAuthority(Authority authority) {
		authority.setUser(this);
		getAppAuthorities().add(authority);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}