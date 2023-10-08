package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dao.Users;

//UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
 Optional<Users> findByMailid(String mailid);

Optional<Users> findById(Integer id);

//boolean existsByMailid(String mailid);

void deleteById(Integer id);
}
