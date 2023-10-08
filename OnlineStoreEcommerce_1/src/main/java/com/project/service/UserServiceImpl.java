package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.error.GlobalException;
import com.project.dao.Users;
import com.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Users registerUser(Users user) throws GlobalException {
        if (userRepository.findByMailid(user.getMailid()).isPresent()) {
            throw new GlobalException("User with this Email Already Exists ");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    
   /* @Override
    public String registerUser(Users user) throws GlobalException {
        boolean emailExists = userRepository.existsByMailid(user.getMailid());
        if (emailExists) {
            throw new GlobalException("User with this email already exists.");
        }

        // Encrypt password
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        userRepository.save(user);

        return "User registered successfully.";*/
    }


    	@Override
        public Users findByMailid(String mailid) {
            return userRepository.findByMailid(mailid).orElse(null);
}
}
