package dev.woori.kkiri.boot.service;

import java.util.List;

import dev.woori.kkiri.boot.model.Post;

public interface PostService extends CrudService<Post, Long> {

	Post findById(Long postId);

	Post save(Post post);

	List<Post> findAll();

}
