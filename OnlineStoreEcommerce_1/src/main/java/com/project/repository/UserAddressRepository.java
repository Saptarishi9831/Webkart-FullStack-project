package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.dao.UserAddress;
@Repository
public interface UserAddressRepository  extends JpaRepository<UserAddress,Integer>{

}
