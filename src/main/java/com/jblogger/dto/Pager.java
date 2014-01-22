package com.jblogger.dto;

import java.util.List;

import com.jblogger.model.Post;

public class Pager {
	private Integer older;
	private Integer newer;
	private List<Post> posts;
	
	public Pager() {}
	
	public Pager(Integer older, Integer newer, List<Post> posts) {
		this.older = older;
		this.newer = newer;
		this.posts = posts;
	}

	public Integer getOlder() {
		return older;
	}

	public void setOlder(Integer older) {
		this.older = older;
	}

	public Integer getNewer() {
		return newer;
	}

	public void setNewer(Integer newer) {
		this.newer = newer;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
