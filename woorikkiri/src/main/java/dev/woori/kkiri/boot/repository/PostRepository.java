package dev.woori.kkiri.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.woori.kkiri.boot.model.Post;

// Like DAO
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	List<Post> findAll();
}
