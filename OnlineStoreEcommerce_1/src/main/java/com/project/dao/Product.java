package com.project.dao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer productId;
	 @NotBlank(message="Please Enter the Product Name")
     private String productName;
     private Float  productPrice;
     private String productSize;
     private String productBrand;
     private String productDescription;
     private Integer productQuantity;
     @NotBlank(message = "Please Enter the Product Image URL")
     @Column(unique = true,length=500)
     private String productImageUrls;
     private Boolean inStock;
     private Timestamp dateadded;
     
     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "product_userid")
     private Users users;
     
     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "category_id")
     private Category category;

     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "subcategory_id")
     private SubCategory subcategory;

     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "sub_sub_category_id")
     private SubSubCategory subSubcategory;

     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "fourthlevelcategory_id")
     private FourthLevelCategory fourthLevelCategory;   
     

	public Product() {
		super();
	}

	public Product(@NotBlank(message = "Please Enter the Product Name") String productName, Float productPrice,
			String productSize, String productBrand, String productDescription, Integer productQuantity,
			@NotBlank(message = "Please Enter the Product Image URL") String productImageUrls, Boolean inStock,
			Timestamp dateadded, Users users, Category category, SubCategory subcategory, SubSubCategory subSubcategory,
			FourthLevelCategory fourthLevelCategory) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSize = productSize;
		this.productBrand = productBrand;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productImageUrls = productImageUrls;
		this.inStock = inStock;
		this.dateadded = dateadded;
		this.users = users;
		this.category = category;
		this.subcategory = subcategory;
		this.subSubcategory = subSubcategory;
		this.fourthLevelCategory = fourthLevelCategory;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductImageUrls() {
		return productImageUrls;
	}

	public void setProductImageUrls(String productImageUrls) {
		this.productImageUrls = productImageUrls;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	public Timestamp getDateadded() {
		return dateadded;
	}

	public void setDateadded(Timestamp dateadded) {
		this.dateadded = dateadded;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public SubSubCategory getSubSubcategory() {
		return subSubcategory;
	}

	public void setSubSubcategory(SubSubCategory subSubcategory) {
		this.subSubcategory = subSubcategory;
	}

	public FourthLevelCategory getFourthLevelCategory() {
		return fourthLevelCategory;
	}

	public void setFourthLevelCategory(FourthLevelCategory fourthLevelCategory) {
		this.fourthLevelCategory = fourthLevelCategory;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productSize=" + productSize + ", productBrand=" + productBrand + ", productDescription="
				+ productDescription + ", productQuantity=" + productQuantity + ", productImageUrls=" + productImageUrls
				+ ", inStock=" + inStock + ", dateadded=" + dateadded + ", users=" + users + ", category=" + category
				+ ", subcategory=" + subcategory + ", subSubcategory=" + subSubcategory + ", fourthLevelCategory="
				+ fourthLevelCategory + "]";
	}
     
     

}