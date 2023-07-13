package dev.woori.kkiri.boot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import dev.woori.kkiri.boot.DTO.LoginDTO;
import dev.woori.kkiri.boot.DTO.UserSaveDTO;
import dev.woori.kkiri.boot.model.User;
import dev.woori.kkiri.boot.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	//private final PasswordEncoder passwordEncoder;


	@Transactional(readOnly = true)
    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        /* 유효성 및 중복 검사에 실패한 필드 목록을 받음 */
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

	@Override
	public Long join(UserSaveDTO userSaveDTO) {
		//userSaveDTO.setPassword(passwordEncoder.encode(userSaveDTO.getPassword()));
		// TODO Auto-generated method stub
		User user = User.builder()
				.name(userSaveDTO.getName())
				.userId(userSaveDTO.getUserId())
				.password(userSaveDTO.getPassword())  
				.className(userSaveDTO.getClassName())
				.phoneNum(userSaveDTO.getPhoneNum())
				.userJoinDate(userSaveDTO.getJoinLocalDate())
				.build();

		return userRepository.save(user).getId();
	}

	@Override
	public Optional<User> findByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUserIdAndPassword(userId, password);
	}

}
