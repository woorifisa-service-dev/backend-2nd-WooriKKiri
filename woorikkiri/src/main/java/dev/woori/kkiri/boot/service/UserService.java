package dev.woori.kkiri.boot.service;

import org.springframework.stereotype.Service;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;

@Service
public interface UserService extends CrudService<User, Long>{

}
