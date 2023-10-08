package com.project.service;
import com.project.error.GlobalException;
import com.project.dao.Users;

public interface UserService {

	//String registerUser(Users user) throws GlobalException;
	public  Users registerUser(Users user) throws GlobalException;

	public Users findByMailid(String mailid);
}