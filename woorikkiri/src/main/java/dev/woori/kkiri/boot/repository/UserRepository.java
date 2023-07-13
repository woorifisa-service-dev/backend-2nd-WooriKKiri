package dev.woori.kkiri.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	boolean existsByPhoneNum(String phoneNum);
	boolean existsByUserId(String userId);
	Optional<User> findByUserIdAndPassword(String userId, String password);

	List<User> findAll();
}
