package dev.woori.kkiri.boot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.woori.kkiri.boot.model.Post;
import dev.woori.kkiri.boot.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	
	// edit
	@GetMapping("/{postId}/edit")
	public ResponseEntity<Post> initUpdatePostForm(@PathVariable Long postId) {
		System.out.println("initform() called");
		Post post = postService.findById(postId);
		return ResponseEntity.ok(post);
	}
	
	@PostMapping("/{postId}/edit")
	public ResponseEntity<Post> processUpdatePostForm(@RequestBody Post updatePost, @PathVariable Long postId) {
		System.out.println("processForm() called");

		Post existingPost = postService.findById(postId);
		
		existingPost.setTitle(updatePost.getTitle());
		existingPost.setContent(updatePost.getContent());
		existingPost.setId(postId);
		
		Post updatedPost = postService.save(existingPost);
		
		return ResponseEntity.ok(updatedPost);
	}
	
	// delete
	@DeleteMapping("/{postid}")
	public Post deletedPost(@PathVariable Long id) {
		postService.deleteById(id);
		return null;
	}
	
}
