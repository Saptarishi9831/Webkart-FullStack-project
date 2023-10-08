package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subcategoryId;

    @NotBlank(message = "Not Blank")
    private String subCategoryName;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="subcategoryId")
    private List<SubSubCategory> subSubCategories = new ArrayList<>();

  
    
	public SubCategory() 
	{
		super();
	}

	public SubCategory(@NotBlank(message = "Not Blank") String subCategoryName, Category category) {
		super();
		this.subCategoryName = subCategoryName;
		this.category = category;
	}


	public Integer getSubCategoryId() {
		return subcategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subcategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subcategoryId + ", subCategoryName=" + subCategoryName + ", category="
				+ category + "]";
	}

	public void setCategoryidToSubCategory(Category cate1) {
		this.category=cate1;
		
	}

	public Integer getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public List<SubSubCategory> getSubSubCategories() {
		return subSubCategories;
	}
	
   
}
