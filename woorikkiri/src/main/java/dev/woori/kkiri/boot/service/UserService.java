package dev.woori.kkiri.boot.service;



import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.User;

@Service
public interface UserService extends CrudService<User, Long> {

	// User id가 일치하는 한 명의 User 정보 반환
	User findByID(Long id);
	
	// MySql에서 id를 활용, 
//	List<User> findByPhoneNum(String PhoneNum);
	
	
	
	User save(User user);

	User getLoggedInUser();


	
}
