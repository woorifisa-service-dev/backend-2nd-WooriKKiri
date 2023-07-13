package dev.woori.kkiri.boot.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import dev.woori.kkiri.boot.dto.UserSaveDTO;
import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;

@Service
public interface UserService extends CrudService<User, Long>{
	
	Map<String, String> validateHandling(Errors errors);

	Long join(UserSaveDTO userSaveDTO);
	
	Optional<User> findByUserIdAndPassword(String userId, String password);
}
