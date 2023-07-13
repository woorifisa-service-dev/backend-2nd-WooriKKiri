package dev.woori.kkiri.boot.service;

public interface CrudService<T, ID> {

	// T(type)을 활용하여 일반화된 메서드로 적용
//	List<T> findAll();

	T findById(ID id);

	// save(저장할 엔티티 받음)
	T save(T object);
	
	//delete(제거할 엔티티 받음)
//	void delete(T object);
	
	// deleteById
//	void deleteById(ID id);

}
