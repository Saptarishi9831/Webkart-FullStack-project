package com.project.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.error.GlobalException;
import com.project.dao.UserAddress;
import com.project.dao.Users;
import com.project.repository.UserAddressRepository;
import com.project.repository.UserRepository;

public class UserAddressServiceImpl implements UserAddressService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserAddressRepository userAddressRepository;
	@Override
	public UserAddress saveUserAddress(@Valid UserAddress useraddress) {
		
		return userAddressRepository.save(useraddress);
	}

	@Override
	public List<UserAddress> getAllUserAddress() {
		
		return userAddressRepository.findAll() ;
	}

	@Override
	public UserAddress getUserAddById(Integer addressid) {

		return userAddressRepository.findById(addressid).get();
	}

	@Override
	public UserAddress updateUserAddressById(Integer addressid, UserAddress updatedUserAddress) throws GlobalException {
	
		Optional<UserAddress> userAddressOptional = userAddressRepository.findById(addressid);
		 if (!userAddressOptional.isPresent())
	     {
			   throw new GlobalException("User Address with id " +  addressid + " not found");
	     }
		        UserAddress existingUser = userAddressOptional.get();
		        existingUser.setArea(updatedUserAddress.getArea());
		        existingUser.setCity(updatedUserAddress. getCity());
		        existingUser.setState(updatedUserAddress.getState());
		        existingUser.setCountry(updatedUserAddress.getCountry());
		        existingUser.setPincode(updatedUserAddress.getPincode());
			    return userAddressRepository.save(existingUser);
		 }

	@Override
	public void deleteUserAddress(Integer addressid) throws GlobalException {
		 Optional<UserAddress> userAddressOptional = userAddressRepository.findById(addressid);
		 if (!userAddressOptional.isPresent())
		 {
		       throw new GlobalException("UserAddress with id " + addressid + " not found");
		  }
		 userAddressRepository.deleteById(addressid);
		  }

	@Override
	public UserAddress setUseridToUserAddress(Integer addressid, Integer id) throws GlobalException {
		 Optional<UserAddress> useradd = userAddressRepository.findById(addressid);
		    if (!useradd.isPresent()) {
		        throw new GlobalException("UserAddress not exist " + addressid);
		    }

		    Optional<Users> user = userRepository.findById(id);
		    if (!user.isPresent()) {
		        throw new GlobalException("Users not exist " + id);
		    }

		    UserAddress useradd1 = userAddressRepository.findById(addressid).get();
		    Users user1 = userRepository.findById(id).get();

		    if (useradd1 != null) {
		    	useradd1.setUsers(user1);
		    }

		    return userAddressRepository.save(useradd1);
		}
	}
	


	
	
	