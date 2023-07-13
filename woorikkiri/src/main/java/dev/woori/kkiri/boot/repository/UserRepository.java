package dev.woori.kkiri.boot.repository;


import org.springframework.data.repository.CrudRepository;

import dev.woori.kkiri.boot.model.User;

public interface UserRepository extends CrudRepository<User, Long> {


}
