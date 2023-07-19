package dev.woori.kkiri.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post object) {
		return postRepository.save(object);
	}

	@Override
	public void delete(Post object) {
		postRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}

}
