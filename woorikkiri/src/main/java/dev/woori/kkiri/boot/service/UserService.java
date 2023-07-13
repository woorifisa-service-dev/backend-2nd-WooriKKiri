package dev.woori.kkiri.boot.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.validation.Errors;

import dev.woori.kkiri.boot.DTO.LoginDTO;
import dev.woori.kkiri.boot.DTO.UserSaveDTO;
import dev.woori.kkiri.boot.model.User;

public interface UserService {
	
	Map<String, String> validateHandling(Errors errors);

	Long join(UserSaveDTO userSaveDTO);
	
	Optional<User> findByUserIdAndPassword(String userId, String password);
}
