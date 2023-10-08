package com.project.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminid;
	@Column(length = 20, nullable = false)
	@NotBlank(message = "Username cannot be blank")
	private String username;
	@Column(length = 20, nullable = false)
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 8, message = "Password must have minimun 8 characters")
	private String password;
	public Admin() {
		super();
		
	}
	public Admin(@NotBlank(message = "Username cannot be blank") String username,
			@NotBlank(message = "Password cannot be blank") @Size(min = 8, message = "Password must have minimun 8 characters") String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminid + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
