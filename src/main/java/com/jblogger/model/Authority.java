package com.jblogger.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.jblogger.model.User;

@Entity
@Table(name = "authorities")
public class Authority {

    private static final long serialVersionUID = 1L;
    
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Integer id;

    //@Column(name = "username", nullable = false)
    //private String username;

    @Column(name = "authority", nullable = false)
    private String authority;

    // Here comes the buggy attribute. It is supposed to repesent the
    // association username<->username, but I just don't know how to
    // implement it 
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    
    public Authority(String username, String authority) {
        Assert.hasText(authority, "A granted authority textual representation is required");
        //this.username = username;
        this.authority = authority;
    }

    public Authority() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
