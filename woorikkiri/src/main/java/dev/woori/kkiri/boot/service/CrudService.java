package dev.woori.kkiri.boot.service;

import java.util.List;

public interface CrudService<T, ID> {

 // T(type)을 활용하여 일반화된 메서들 적용
	List<T> findAll();
	
	
// save(저장할 엔티티)
	T save(T object);

	
// delete(제거할 엔티티)
//	void delete(T object);
//
//	
// deleteById
//void deleteById(ID id);
}

