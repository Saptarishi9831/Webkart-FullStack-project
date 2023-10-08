package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.dao.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

	Admin findByUsername(String username);

	Admin findByUsernameAndPassword(String username, String password);

	//Admin getAdminByusername(String username, String password);

}
