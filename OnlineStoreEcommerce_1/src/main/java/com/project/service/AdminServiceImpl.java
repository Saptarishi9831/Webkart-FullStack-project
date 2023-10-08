package com.project.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.Admin;
import com.project.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin adminlogin(@Valid Admin admin) {
		
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return adminRepository.findAll();
	}

	@Override
	public Admin findByUsername(String username) {
		
		return adminRepository.findByUsername(username);
	}

	/*@Override
	public Admin getAdminByusername(String username, String password) {
		
		return adminRepository.getAdminByusername(username,password);
	}*/


}
