package dev.woori.kkiri.boot.dto;

import java.util.Date;

import dev.woori.kkiri.boot.model.Post;
//import dev.woori.kkiri.boot.model.User;
import lombok.Getter;

@Getter
public class PostResponse {
//	private User user;
	private String title;
	private Date postDate;
	private String content;
//	private List<String> photo;
	private boolean isRecruit;
	
public PostResponse(String title, Date postDate, String content, boolean isRecruit) {
	super();
//	this.user = user;
	this.title = title;
	this.postDate = postDate;
	this.content = content;
	this.isRecruit = isRecruit;
}

public static PostResponse from(Post post) {
//	final User user = post.getId();
	final String title = post.getTitle();
	final Date postDate = post.getPostDate();
	final String content = post.getContent();
	final boolean isRecruit = post.isRecruit();
	
	
	return new PostResponse( title, postDate, content, isRecruit);
}
	
	
}
