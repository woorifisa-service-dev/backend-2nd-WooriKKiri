package dev.woori.kkiri.boot.dto;

import java.util.List;

import dev.woori.kkiri.boot.model.Post;
import lombok.Setter;


@Setter
public class MyPageResponse {

	private Long userId;
	private String userPhoneNum;
	private List<Post> recruitedPosts;
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		
	}
	
	
//	public void setUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}

//	public void setRecruitedPosts(List<Post> recruitedPosts) {
//		// TODO Auto-generated method stub
//		
//	}

	

}
