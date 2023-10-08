package com.project.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressid;
	
	@NotBlank(message = "Please enter area")
	@Column(nullable = false, length = 40)
	private String area;
	
	@NotBlank(message = "Please enter city")
	@Column(nullable = false, length = 20)
	private String city;
	
	@NotBlank(message = "Please enter state")
	@Column(nullable = false, length = 20)
	private String state;
	
	@NotBlank(message = "Please enter country")
	@Column(nullable = false, length = 20)
	private String country;
	
	@Column(length = 6, nullable = false)
	@Size(min = 6, max = 6, message = "Pincode must be 6 digit")
	private String pincode;
	
	 
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userid")
    private Users users;


	public UserAddress() {
		super();
		
	}


	public UserAddress(@NotBlank(message = "Please enter area") String area,
			@NotBlank(message = "Please enter city") String city,
			@NotBlank(message = "Please enter state") String state,
			@NotBlank(message = "Please enter country") String country,
			@Size(min = 6, max = 6, message = "Pincode must be 6 digit") String pincode, Users users) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.users = users;
	}


	public Integer getAddressid() {
		return addressid;
	}


	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "UserAddress [addressid=" + addressid + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + ", users=" + users + "]";
	}
    
    
}
