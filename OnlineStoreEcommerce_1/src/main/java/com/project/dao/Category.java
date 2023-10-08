package com.project.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

//Category Instance Variable
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid;

    @NotBlank(message = "Not Blank")
    private String categoryName;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="categoryid")
    private List<SubCategory> subCategories = new ArrayList<>();

    
    
 
	public Category(@NotBlank(message = "Not Blank") String categoryName, List<SubCategory> subCategories) {
		super();
		this.categoryName = categoryName;
		this.subCategories = subCategories;
	}
	public Category() {
		super();
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryName=" + categoryName + ", subCategories="
				+ subCategories + "]";
	}
   
}
