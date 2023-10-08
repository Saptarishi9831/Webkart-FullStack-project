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
public class SubSubCategory {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer subSubCategoryId;
		
	    @NotBlank(message = "Not Blank")
		private String subSubCategoryName;

	    
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "categoryid")
	    private Category category;
	    
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "subcategoryId")
	    private SubCategory subcategory;


	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="subSubCategoryId")
	    private List<FourthLevelCategory> fourthLevelCategory = new ArrayList<>();
	
	    
	    @JsonIgnore
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="subSubCategoryId")
	    private List<FourthLevelCategory> fourthLevelCategories = new ArrayList<>();


		public SubSubCategory(@NotBlank(message = "Not Blank") String subSubCategoryName, Category category,
				SubCategory subcategory) {
			super();
			this.subSubCategoryName = subSubCategoryName;
			this.category = category;
			this.subcategory = subcategory;
		}



		public SubSubCategory() {
			super();
		}



		public Integer getSubSubCategoryId() {
			return subSubCategoryId;
		}



		public void setSubSubCategoryId(Integer subSubCategoryId) {
			this.subSubCategoryId = subSubCategoryId;
		}



		public String getSubSubCategoryName() {
			return subSubCategoryName;
		}



		public void setSubSubCategoryName(String subSubCategoryName) {
			this.subSubCategoryName = subSubCategoryName;
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



		@Override
		public String toString() {
			return "SubSubCategory [subSubCategoryId=" + subSubCategoryId + ", subSubCategoryName=" + subSubCategoryName
					+ ", category=" + category + ", subcategory=" + subcategory + "]";
		}


       public List<FourthLevelCategory> getFourthLevelCategories() {
		
			return fourthLevelCategories;
		}


		
	    
}
