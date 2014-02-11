package com.jblogger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="post")
public class Post {
	
	public static final int BODY_SUMMARY_MAX_LENGTH = 200;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=255)
	private String title;
	
	@Column(columnDefinition="TEXT")
	@NotNull
	@Size(min=2, max=5000)
	private String body;
	
	@Temporal(TemporalType.DATE)
	private Date published;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinColumn(name="post_id")
	List<Comment> comments = new ArrayList<Comment>();
	
	public Post() {}
	
	public Post(String title, String body, Date published) {
		this.title = title;
		this.body = body;
		this.published = published;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}
	
	public String getBodySummary() {
		// Remove all html entities from the body
		String summary = body.replaceAll("\\<.*?\\>", "");
		
		// If the summary is short then leave it at that length
		if (summary.length() <= BODY_SUMMARY_MAX_LENGTH) {
			return summary;
		}
		
		// Shorten it to a rough amount
		summary = summary.substring(0, BODY_SUMMARY_MAX_LENGTH);
		
		// Take it to the last fullstop if it exists
		int idx = summary.lastIndexOf(".");
		if (idx != -1) {
			summary = summary.substring(0, idx + 1);
		}
		
		return summary;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		comment.setPost(this);
		comments.add(comment);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body
				+ ", published=" + published + "]";
	}
	
	
}
