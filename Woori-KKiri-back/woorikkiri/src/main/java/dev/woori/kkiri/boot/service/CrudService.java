package dev.woori.kkiri.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.Post;

@Service
public interface CrudService<T, ID>{
	
	List<T> findAll();
	
	T findById(ID id);
	
	T save(T object);
	
	void delete(T object);
	
	void deleteById(ID id);

}
