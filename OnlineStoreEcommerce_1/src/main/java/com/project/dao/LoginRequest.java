package com.project.dao;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {
	 @Column(unique=true,nullable=false)
	 @NotBlank(message = "Email is required")
	 @Email(message = "Invalid email format",regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	 private String mailid;

	 @NotBlank(message = "Password is required")
	 @Size(min = 8, message = "Password must have minimun 8 characters")
	 private String password;

	 
	public LoginRequest() {
		super();
		
	}

	public LoginRequest(
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}") String mailid,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must have minimun 8 characters") String password) {
		super();
		this.mailid = mailid;
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [mailid=" + mailid + ", password=" + password + "]";
	}

	public String getUsername() {
		
		return null;
	} 

}
