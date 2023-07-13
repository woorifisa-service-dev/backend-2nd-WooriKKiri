package dev.woori.kkiri.boot.DTO;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {
	@NotBlank(message="아이디를 입력하세요")
	private String userId;
	
	@NotBlank(message="비밀번호를 입력하세요")
	private String password;
}
