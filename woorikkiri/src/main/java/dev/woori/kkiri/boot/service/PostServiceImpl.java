package dev.woori.kkiri.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Override
	public Post findById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	
}
