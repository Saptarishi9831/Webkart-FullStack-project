package com.project.service;

import java.util.List;

import javax.validation.Valid;

import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;

public interface SubSubCategoryService {

	public SubSubCategory createSubSubCategory(@Valid SubSubCategory subsubcategory);

	public List<SubSubCategory> getAllSubSubCategories();
	
	public SubSubCategory getSubSubCategoryById(Integer subSubCategoryId) throws GlobalException;
	
	
	

	public void deleteSubSubCategory(Integer subSubCategoryId) throws GlobalException;


	public SubSubCategory setCategoryidToSubSubCategory(Integer subSubCategoryId, Integer categoryid) throws GlobalException;

	public SubSubCategory setsubcategoryidToSubSubCategory(Integer subSubCategoryId, Integer subcategoryId) throws GlobalException;

	public SubSubCategory updateSubSubCategory(Integer subSubCategoryId, Integer categoryid, Integer subcategoryId,
			SubSubCategory updatedSubSubCategory) throws GlobalException;



	


	
	
}
