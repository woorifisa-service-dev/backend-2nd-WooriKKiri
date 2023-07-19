package dev.woori.kkiri.boot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User extends BaseEntity {
	
	@Column(name = "user_pw")
	private String password;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String name;
	 
	@Column(name = "user_phone_num")
	private String phoneNum;
	
	@Column(name = "user_join_date")
	@CreationTimestamp
	private LocalDate userJoinDate;
	
	@JsonIgnore 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Post> posts = new ArrayList<>();

	@Builder
	public User(Long id, String userId, String password, String className, String name, String phoneNum, LocalDate userJoinDate) {
		super(id);
		this.userId = userId;
		this.password = password;
		this.className = className;
		this.name = name;
		this.phoneNum = phoneNum;
		this.userJoinDate = userJoinDate;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", className=" + className + ", name=" + name + ", phoneNum=" + phoneNum
				+ "]";
	}
	
}
