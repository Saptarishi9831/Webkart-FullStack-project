package com.project.service;

import java.util.List;

import javax.validation.Valid;

import com.project.dao.Admin;

public interface AdminService {

	Admin adminlogin(@Valid Admin admin);

	List<Admin> getAllAdmins();

	Admin findByUsername(String username);

	//Admin getAdminByusername(String username, String password);




}
