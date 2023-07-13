package dev.woori.kkiri.boot.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PostRequest {
	
	// @Pattern: 유효성 처리할 때 간단하게 쓸 수 있는 어노테이션 
	@NotNull @Size(min = 1, max = 30)
	private String title;
	@NotNull
	private String content;

	public PostRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
