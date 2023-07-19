package dev.woori.kkiri.boot.service;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.Post;

@Service
public interface PostService extends CrudService<Post, Long>{
	

}
