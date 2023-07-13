package dev.woori.kkiri.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.User;
import dev.woori.kkiri.boot.repository.UserRepository;


@Service
public class UserServiceImplement implements UserService {

	private final UserRepository userRepository;

	
	public UserServiceImplement(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<User> findByPhoneNum(String PhoneNum) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getLoggedInUser() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
