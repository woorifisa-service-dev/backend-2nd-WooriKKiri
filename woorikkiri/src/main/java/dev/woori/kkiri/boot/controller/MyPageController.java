package dev.woori.kkiri.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;
import dev.woori.kkiri.boot.service.PostService;
//import dev.woori.kkiri.boot.service.PostService;
import dev.woori.kkiri.boot.service.UserService;

@RequestMapping("/mypage")
@Controller
public class MyPageController {

	/*
	 * User의 id, phoneNum
	 * Post의 정보들이 담긴 공구 list : 참여정보 목록 차례로 띄우기
	 * 
	 * post의 list에 참여하면,
	 * 내가 참여한 공구들이 마이페이지에 자동 연동되도록 목록 구성
	 * 
	 */
	

	 private final UserService userService;
	    private final PostService postService;

	    @Autowired
	    public MyPageController(UserService userService, PostService postService) {
	        this.userService = userService;
	        this.postService = postService;
	    }

	    @GetMapping
	    public String myPage(Model model) {
	        // 현재 로그인한 사용자 정보 가져오기
	        User user = userService.getLoggedInUser();

	        // 사용자가 참여한 공동구매 정보 가져오기
	        List<Post> recruitedPosts = postService.getRecruitedPostsByUser(user);

	        // 모델에 데이터 전달
	        model.addAttribute("user", user);
	        model.addAttribute("recruitedPosts", recruitedPosts);

	        // MyPage 뷰 페이지로 이동
	        return "mypage";
	    }
	
	
}


