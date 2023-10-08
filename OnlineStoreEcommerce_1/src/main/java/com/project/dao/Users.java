package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Users {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 @Column(nullable=false,length=20)
	 @NotBlank(message = "First Name is required")
	 @Size(min=3,message="Name should be greater than 3 characters")
	 @Size(max=20,message="Name should be less than 20 characters")
	 private String firstname;

	 @Column(nullable=false,length=20)
	 @Size(min=3,message="Name should be greater than 3 characters")
	 @Size(max=20,message="Name should be less than 20 characters")
	 @NotBlank(message = "Last Name is required")
	 private String lastname;

	 @Column(unique=true,nullable=false)
	 @NotBlank(message = "Email is required")
	 @Email(message = "Invalid email format",regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	 private String mailid;
	 
	 @Transient
	 private String rawPassword;
	 
	 @Column(nullable = false, length = 255)
	 @NotBlank(message = "Password is required")
	 @Size(min=8)
	 private String password;

	 @Column(unique=true,nullable=false)
	 @NotBlank(message = "Mobile Number is required")
	 @Pattern(regexp = "\\d{10}", message = "Invalid mobile number format")
	 private String mobilenumber;
	 
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="product_userid")
	 private List<Product> product = new ArrayList<>();
	 

	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="userid")
	 private List<UserAddress> userAddresses;


	public Users() {
		super();
	}


	public Users(Integer id,
			@NotBlank(message = "First Name is required") @Size(min = 3, message = "Name should be greater than 3 characters") @Size(max = 20, message = "Name should be less than 20 characters") String firstname,
			@Size(min = 3, message = "Name should be greater than 3 characters") @Size(max = 20, message = "Name should be less than 20 characters") @NotBlank(message = "Last Name is required") String lastname,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}") String mailid,
			String rawPassword, @NotBlank(message = "Password is required") @Size(min = 8) String password,
			@NotBlank(message = "Mobile Number is required") @Pattern(regexp = "\\d{10}", message = "Invalid mobile number format") String mobilenumber,
			List<Product> product, List<UserAddress> userAddresses) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mailid = mailid;
		this.rawPassword = rawPassword;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.product = product;
		this.userAddresses = userAddresses;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}


	public String getRawPassword() {
		return rawPassword;
	}


	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
		this.password = new BCryptPasswordEncoder().encode(rawPassword);
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}


	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mailid=" + mailid
				+ ", rawPassword=" + rawPassword + ", password=" + password + ", mobilenumber=" + mobilenumber
				+ ", product=" + product + ", userAddresses=" + userAddresses + "]";
	}

}