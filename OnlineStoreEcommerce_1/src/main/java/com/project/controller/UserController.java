package com.project.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.error.GlobalException;
import com.project.dao.LoginRequest;
import com.project.dao.Users;
import com.project.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

        @PostMapping("/register")
        public ResponseEntity<String> registerUser(@Valid @RequestBody Users user) {
            try {
                userService.registerUser(user);
                return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);
            } catch (GlobalException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); 
            }
        }
        
        @PostMapping("/login")
        public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
            try {
                Users user = userService.findByMailid(loginRequest.getMailid());
                if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                    return new ResponseEntity<>("Login Successful", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
                }
            } 
            catch (Exception e) {
                return new ResponseEntity<>("An error occurred during login", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
  

   