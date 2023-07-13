package dev.woori.kkiri.boot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.woori.kkiri.boot.dto.PostRequest;
import dev.woori.kkiri.boot.dto.PostResponse;
import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.model.User;
import dev.woori.kkiri.boot.service.PostService;
import dev.woori.kkiri.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/post")
@RestController
public class PostController {
	
	private final PostService postService;
	private final UserService userService;
	
	public PostController(PostService postService, UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}
	
	// 모든 게시글 조회 
	@GetMapping("/list")
	public ResponseEntity<List<PostResponse>> listPosts(){
		List<Post> posts = postService.findAll();
		
		List<PostResponse> postResponse = posts.stream()
				.map(PostResponse::from)
				.collect(Collectors.toList());
		log.info("hello");
		System.out.println(postResponse);
		return ResponseEntity.ok(postResponse);
	}
	
	// Post 필드들 확인하고 추가 
	@PostMapping("/new/{userId}")
    public ResponseEntity<PostResponse> addPost(@PathVariable Long userId, @Valid @RequestBody PostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        // 현재 날짜 구하기 (작성 시간) 
        LocalDate now = LocalDate.now();
        LocalDate postDate = now;
        boolean isRecruit = true;
        post.setPostDate(postDate);
        post.setRecruit(isRecruit);
        User user = userService.findById(userId);
        post.setUser(user);

        Post savedPost = postService.save(post);
        PostResponse postResponse = PostResponse.from(savedPost);

        log.info("New post created: {}", postResponse);
        return ResponseEntity.ok(postResponse); // HTTP 상태 코드 200 OK와 함께 응답을 생성하는 정적 팩토리 메서드. 즉, 클라이언트에게 성공적인 응답을 전달할 때 사용
    }
	// TODO
	// 팀원들 경로 통일 
	// Vue.js 지선생 도움 받아서 만들어보기, 스프링부트 파일이랑 연결해보기  
	
	// 게시글 수정 
	@GetMapping("/edit/{postId}/{userId}")
	public ResponseEntity<PostResponse> editPosts(@PathVariable Long postId, @PathVariable Long userId){
		Post post = postService.findById(postId);
		
		User user = post.getUser();
		if (user == null || !user.getId().equals(userId)) {
			// 수정 하려는 유저와 게시글 작성자가 다른 경우 에러 응답을 반환
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		// 수정하려는 게시글이 없는 경우 에러 응답을 반환하거나 다른 처리 수행 
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		
		// 수정하려는 게시글 가져오기 
		PostResponse postResponse = PostResponse.from(post);
		return ResponseEntity.ok(postResponse);
	}
	
	@PatchMapping("/edit/{postId}")
	public ResponseEntity<PostResponse> updatePosts(@PathVariable Long postId, @Valid @RequestBody PostRequest postRequest){
		Post post = postService.findById(postId);
		
		// 수행하려는 게시글이 없는 경우 에러응답 반환 
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		
		post.setTitle(postRequest.getTitle());
		post.setContent(postRequest.getContent());
		
		Post savedPost = postService.save(post);
		PostResponse postResponse = PostResponse.from(savedPost);
		
		log.info("Post updated:{}", postResponse);
		return ResponseEntity.ok(postResponse);
	}
	
	// 게시글 삭제
	@DeleteMapping("/delete/{postId}/{userId}")
	public ResponseEntity<Void> deletePost(@PathVariable Long postId, @PathVariable Long userId) {
		Post post = postService.findById(postId);
		if (post == null) {
			// 삭제하는 게시글 존재하지 않으면 에러 응답 반환 
			return ResponseEntity.notFound().build();
		}
		
		User user = post.getUser();
		if (user == null || !user.getId().equals(userId)) {
			// 삭제하려는 유저와 게시글 작성자가 다른 경우 에러 응답을 반환
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		// 게시글 삭제하기 
		postService.deleteById(postId);
		
		// 삭제가 성공적으로 이루어진 경우, HTTP 상태 코드 204 No Content를 반환 
		return ResponseEntity.noContent().build(); 
	}
	

//	// Vue 파일에서 게시글 추가 후 페이지 이동하는 코드 예시
//
//	// 게시글 추가 메서드
//	async addPost() {
//	  try {
//	    const response = await axios.post('/api/new-post', postData); // POST 요청 보내기
//	    const postId = response.data; // 받은 게시글 ID
//
//	    // 게시글 추가 후 페이지 이동
//	    this.$router.push(`/post/list/${postId}`);
//	  } catch (error) {
//	    console.error(error);
//	  }
//	}	
	

}
