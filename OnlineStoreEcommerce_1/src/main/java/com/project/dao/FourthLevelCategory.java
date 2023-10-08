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

public class FourthLevelCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fourthlevelcategoryId;

    @NotBlank(message = "Not Blank")
    private String fourthlevelcategoryname;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subcategoryId")
    private SubCategory subcategory;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subSubCategoryId")
    private SubSubCategory subSubCategory;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fourthlevelcategoryid")
    private List<Product> products;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fourth_level_category_id")
    private List<ImageFourthCategory> images = new ArrayList<>();

	public FourthLevelCategory() {
		super();
		
	}

	public FourthLevelCategory(@NotBlank(message = "Not Blank") String fourthlevelcategoryname, Category category,
			SubCategory subcategory, SubSubCategory subSubCategory, List<Product> products,
			List<ImageFourthCategory> images) {
		super();
		this.fourthlevelcategoryname = fourthlevelcategoryname;
		this.category = category;
		this.subcategory = subcategory;
		this.subSubCategory= subSubCategory;
		this.products = products;
		this.images = images;
	}

	public Integer getFourthlevelcategoryId() {
		return fourthlevelcategoryId;
	}

	public void setFourthlevelcategoryId(Integer fourthlevelcategoryId) {
		this.fourthlevelcategoryId = fourthlevelcategoryId;
	}

	public String getFourthlevelcategoryname() {
		return fourthlevelcategoryname;
	}

	public void setFourthlevelcategoryname(String fourthlevelcategoryname) {
		this.fourthlevelcategoryname = fourthlevelcategoryname;
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

	public SubSubCategory getSubSubCategory() {
		return subSubCategory;
	}

	public void setSubSubCategory(SubSubCategory subSubCategory) {
		this.subSubCategory = subSubCategory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<ImageFourthCategory> getImages() {
		return images;
	}

	public void setImages(List<ImageFourthCategory> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "FourthLevelCategory [fourthlevelcategoryId=" + fourthlevelcategoryId + ", fourthlevelcategoryname="
				+ fourthlevelcategoryname + ", category=" + category + ", subcategory=" + subcategory
				+ ", subSubCategory=" + subSubCategory + ", products=" + products + ", images=" + images + "]";
	}

	
    

}
    
    