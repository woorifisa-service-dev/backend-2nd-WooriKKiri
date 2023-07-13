package dev.woori.kkiri.boot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	private String password;
	
	@Column(name = "class_name")
	private String className;
	
	private String name;
	
	@Column(name = "phone_num")
	private String phoneNum;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Post> posts = new ArrayList<>();

	@Builder
	public User(Long id, String password, String className, String name, String phoneNum, List<Post> posts) {
		super(id);
		this.password = password;
		this.className = className;
		this.name = name;
		this.phoneNum = phoneNum;
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", className=" + className + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", posts=" + posts + "]";
	}
	
}
