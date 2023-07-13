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
	private User user;
	private String title;
	private LocalDate postDate;
	private String content;
	private boolean isRecruit;
	
	@Builder
	public PostResponse(Long id, User user, String title, LocalDate postDate, String content, boolean isRecruit) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.postDate = postDate;
		this.content = content;
		this.isRecruit = isRecruit;
	}
	
	public static PostResponse from(Post post) {
		final Long id = post.getId();
		final User user = post.getUser();
		final String title = post.getTitle();
		final LocalDate postDate = post.getPostDate();
		final String content = post.getContent();
		final boolean isRecruit = post.isRecruit();
		
		return new PostResponse(id, user, title, postDate, content, isRecruit);
	}

	@Override
	public String toString() {
		return "PostResponse [id=" + id + ", user=" + user + ", title=" + title + ", postDate=" + postDate
				+ ", content=" + content + ", isRecruit=" + isRecruit + "]";
	}

}
