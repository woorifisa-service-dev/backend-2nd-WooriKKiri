package dev.woori.kkiri.boot.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {
	@NotBlank(message="핸드폰 번호를 입력하세요")
	private String phoneNum;
	
	@NotBlank(message="이름을 입력하세요")
	@Size(min = 2, max = 5, message = "이름은 2~5글자 사이입니다.")
	private String name;
	
	@NotBlank(message="아이디를 입력하세요")
	private String userId;
	
	@NotBlank(message="비밀번호를 입력하세요")
	private String password;
	
	@NotBlank(message="반 이름을 입력하세요")
	private String className;

	private LocalDate joinLocalDate;
}