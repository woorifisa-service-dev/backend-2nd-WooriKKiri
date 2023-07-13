package dev.woori.kkiri.boot.service;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.repository.UserRepository;

@Service
public class UserServiceImpl {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


//	@Override
//	public User findById(Long userId) {
//		return userRepository.findById(userId).orElse(null);
//	}
	
}
