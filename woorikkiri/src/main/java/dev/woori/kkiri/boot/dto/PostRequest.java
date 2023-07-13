package dev.woori.kkiri.boot.dto;


import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PostRequest {

	@NotNull 
	private String title;

	@NotNull 
	private String content;

//	private List<String> photo;

	
	public PostRequest(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

}
