package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.dao.UserAddress;
import com.project.error.GlobalException;
import com.project.service.UserAddressService;

public class UserAddressController {

	@Autowired
	private UserAddressService userAddressService;
	
	@PostMapping("/saveUserAddress")
	public ResponseEntity<UserAddress> saveUserAddress(@Valid @RequestBody UserAddress useraddress){
		UserAddress address =userAddressService.saveUserAddress(useraddress);
		return new ResponseEntity<UserAddress>( address, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUserAddress")
	List<UserAddress> getAllUserAddress(){
		return userAddressService.getAllUserAddress();
	}
	
	
	@GetMapping("/getUserAddById/{addressid}")
	public UserAddress getUserAddById(@PathVariable("addressid") Integer addressid) {
		return userAddressService.getUserAddById(addressid);
	}
	
	 @PutMapping("/updateUserAddressById/{addressid}")
	    public ResponseEntity<String> updateUserAddressById(@PathVariable Integer addressid, @RequestBody UserAddress updatedUserAddress) throws GlobalException {
	        UserAddress userAddress = userAddressService.updateUserAddressById(addressid, updatedUserAddress);
	        if (userAddress != null) {
	            return new ResponseEntity<>("UserAddress Updated Successfully", HttpStatus.OK);
	        } else {
	            throw new GlobalException("User address with ID " + addressid + " not found");
	        }
	    }

	 
	 @DeleteMapping("/deleteUserAddress/{addressid}")
	    public ResponseEntity<String> deleteUserAddress(@PathVariable Integer addressid) throws GlobalException {
		 userAddressService. deleteUserAddress(addressid);
	        return new ResponseEntity<>("UserAddresss with ID " + addressid + " deleted successfully", HttpStatus.OK);
	    }
	 
	 @PutMapping("/setUseridToUserAddress/{addressid}/{id}")
	  public UserAddress setUseridToUserAddress(@PathVariable("addressid") Integer addressid,@PathVariable("id") Integer id) throws GlobalException
	  {
		return userAddressService.setUseridToUserAddress(addressid,id);
		  
	  }



}
