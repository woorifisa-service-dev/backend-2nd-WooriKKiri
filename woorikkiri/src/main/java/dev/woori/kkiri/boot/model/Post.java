package dev.woori.kkiri.boot.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post extends BaseEntity{
	
	@ManyToOne
	@JoinColumn()
	private User user;
	
	private String title;
	
	@Column(name = "post_date")
	private LocalDate postDate;
	
	private String content;
	
	// TODO: 사진 업로드 기능 나중에 구현 
//	@ElementCollection
//	private List<String> photo;
	
	@Column(name = "is_recruit")
	private boolean isRecruit;

	@Builder
	public Post(Long id, User user, String title, LocalDate postDate, String content,
			boolean isRecruit) {
		super(id);
		this.user = user;
		this.title = title;
		this.postDate = postDate;
		this.content = content;
		this.isRecruit = isRecruit;
	}

	@Override
	public String toString() {
		return "Post [user=" + user + ", title=" + title + ", postDate=" + postDate + ", content=" + content
				+ ", isRecruit=" + isRecruit + "]";
	}

}
