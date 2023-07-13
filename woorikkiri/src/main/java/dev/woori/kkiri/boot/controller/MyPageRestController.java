//package dev.woori.kkiri.boot.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import dev.woori.kkiri.boot.dto.MyPageResponse;
//import dev.woori.kkiri.boot.model.Post;
//import dev.woori.kkiri.boot.model.User;
//import dev.woori.kkiri.boot.service.UserService;
//import lombok.RequiredArgsConstructor;
//
//@RequestMapping("/api/mypage")
//@RestController
//@RequiredArgsConstructor
//public class MyPageRestController {
//
//	private final UserService userService;
//
//	/*
//	 * CSR방식으로 user의 정보를 가져오는 API
//	 * 
//	 */
//	
//	@GetMapping
//    public MyPageResponse myPage() {
//        // 현재 로그인한 사용자 정보 가져오기
//        User user = userService.findByID(userSaveDTO.getUserId);
//
//        // 사용자의 id와 phoneNum, name 값만 가져오기
//        Long userId  = user.getId();
//        String userPhoneNum = user.getPhoneNum();
//        String userName = user.getName();
//        List<Post> posts = user.getPosts();
//
//        
//        // 사용자가 참여한 공동구매 정보 가져오기 
//        // isRecruit=true인 데이터 필터링
//        List<Post> recruitedPosts = posts.stream()
//                .filter(Post::isRecruit)
//                .collect(Collectors.toList());
//       
//        
//        // MyPageResponse 객체 생성 및 데이터 설정
//        MyPageResponse myPageResponse = new MyPageResponse();
//        myPageResponse.setUserId(userId);
//        myPageResponse.setUserPhoneNum(userPhoneNum);
//        myPageResponse.setUserName(userName);
//        myPageResponse.setRecruitedPosts(recruitedPosts);
//
//        return myPageResponse;
//    }
//}