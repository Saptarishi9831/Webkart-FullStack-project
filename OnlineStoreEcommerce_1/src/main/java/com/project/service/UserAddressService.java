package com.project.service;

import java.util.List;
import javax.validation.Valid;
import com.project.error.GlobalException;
import com.project.dao.UserAddress;

public interface UserAddressService {

	public UserAddress saveUserAddress(@Valid UserAddress useraddress);

	public List<UserAddress> getAllUserAddress();

	public UserAddress getUserAddById(Integer addressid);

	public UserAddress updateUserAddressById(Integer addressid, UserAddress updatedUserAddress) throws GlobalException;

	public void deleteUserAddress(Integer addressid) throws GlobalException;

	public UserAddress setUseridToUserAddress(Integer addressid, Integer id) throws GlobalException;

	
	

}
