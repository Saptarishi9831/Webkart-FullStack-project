package com.project.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.dao.Admin;
import com.project.dao.LoginRequest;
import com.project.dao.Users;
import com.project.service.AdminService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	     @PostMapping("/addAdmin")
	    public ResponseEntity<String> adminlogin(@Valid @RequestBody Admin admin) {
	        Admin admins = adminService.adminlogin(admin);
	        if (admins != null) 
	        {
	            return new ResponseEntity<>("Admin Added Succeesfully", HttpStatus.CREATED);
	        } 
	        else 
	        {
	            return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    
	     }
	     @GetMapping("/getAllAdmins")
	     public ResponseEntity<List<Admin>> getAllAdmins() 
	     {
	         List<Admin> admin = adminService.getAllAdmins();
	         return new ResponseEntity<>(admin, HttpStatus.OK);
	     }

	     @PostMapping("/adminLogin")
	     public ResponseEntity<Map<String, String>> login(@Valid @RequestBody Admin admin) {
	         try {
	             Admin adminFromDb = adminService.findByUsername(admin.getUsername());
	             if (adminFromDb != null && admin.getPassword().equals(adminFromDb.getPassword())) {
	                 Map<String, String> response = new HashMap<>();
	                 response.put("message", "Login Successful");
	                 return ResponseEntity.ok(response);
	             } else {
	                 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Invalid username or password"));
	             }
	         } catch (Exception e) {
	             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "An error occurred during login"));
	         }
	     }

	     /*@GetMapping("/getAdminByusername/{username}/{password}")
	 	public Admin getAdminByusername(@PathVariable("username") String username,@PathVariable("password") String password) {
	 		return adminService.getAdminByusername(username,password);
	 	}*/
}
