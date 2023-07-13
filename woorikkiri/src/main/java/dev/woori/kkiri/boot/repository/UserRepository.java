package dev.woori.kkiri.boot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.woori.kkiri.boot.model.User;

public interface UserRepository extends CrudRepository<User, Long> {


	Optional<User> findById(Long id);
	
	
	
	
}
