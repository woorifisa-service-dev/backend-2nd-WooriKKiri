package dev.woori.kkiri.boot.dto;

import java.util.List;
import java.util.stream.Collectors;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

	private Long id;
	private String password;
	private String className;
	private String phoneNum;
	private List<PostResponse> posts;
	
	@Builder
	public UserResponse(Long id, String password, String className, String phoneNum, List<PostResponse> posts) {
		super();
		this.id = id;
		this.password = password;
		this.className = className;
		this.phoneNum = phoneNum;
		this.posts = posts;
	}
	
	public static UserResponse from(User user) {
		final Long id = user.getId();
		final String password = user.getPassword();
		final String className = user.getClassName();
		final String phoneNum = user.getPhoneNum();
		final List<PostResponse> posts = user.getPosts().stream()
				.map(PostResponse::from)
				.collect(Collectors.toList());
		return new UserResponse(id, password, className, phoneNum, posts);
	}
	
	
	
	

}
