package dev.woori.kkiri.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.woori.kkiri.boot.model.Post;

// DB에 접근하는 객체 
@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	List<Post> findAll();
	
	Optional<Post> findById(Long id);
}
