package dev.woori.kkiri.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.service.PostService;
import dev.woori.kkiri.boot.service.UserService;

@RequestMapping("/Login")
@RestController
public class UserController {
	
	private final PostService postService;
	private final UserService userService;
	
	public UserController(PostService postService, UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}
	
	// 로그인 후 보여지는 홈 화면 -> UserController에서 ! 
		@GetMapping
		public String showPosts(Post post, Model model) {
			model.addAttribute("post", postService.findAll());
			return "posts";
		}

}
