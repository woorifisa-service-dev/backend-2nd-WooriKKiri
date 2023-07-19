package dev.woori.kkiri.boot.dto;

import java.time.LocalDate;
import java.util.Date;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
	private Long id;
	private String userName;
	private String title;
	private String postDate;
	private String content;
	private boolean isRecruit;
	
	@Builder
	public PostResponse(Long id, String userName, String title, String postDate, String content, boolean isRecruit) {
		this.id = id;
		this.userName = userName;
		this.title = title;
		this.postDate = postDate;
		this.content = content;
		this.isRecruit = isRecruit;
	}
	
	public static PostResponse from(Post post) {
		final Long id = post.getId();
		final String userName = post.getUserName();
		final String title = post.getTitle();
		final String postDate = post.getPostDateByString();
		final String content = post.getContent();
		final boolean isRecruit = post.isRecruit();
		
		return new PostResponse(id, userName, title, postDate, content, isRecruit);
	}



}
