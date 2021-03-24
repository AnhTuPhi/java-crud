package com.java.container.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id", nullable = false)
	private long user_id;
	
	@Column(name = "Full_Name", length = 128, nullable = false)
	private String fullname;
	
	@Column(name = "Email_User", length = 62, nullable = false)
	private String email_user;
	
	@Column(name = "Gender_User", length = 36, nullable = false)
	private String gender_user;
	
	@Column(name = "Username", length = 36, nullable = false)
	private String username;
	
	@Column(name = "Encryted_Password", length = 128, nullable = false)
	private String encrytedPassword;
	
	@Column(name = "User_Role", length = 36, nullable = false)
	private String user_role;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long id_user) {
		this.user_id = id_user;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public String getGender_user() {
		return gender_user;
	}
	public void setGender_user(String gender_user) {
		this.gender_user = gender_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEncrytedPassword() {
		return encrytedPassword;
	}
	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
}
