package com.project.service;

import java.util.List;

import javax.validation.Valid;

import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;

public interface SubCategoryService {

	public SubCategory createSubCategory(@Valid SubCategory subcategory);

	public List<SubCategory> getAllSubCategories();

	public SubCategory getSubCategoryById(Integer subCategoryId) throws GlobalException;

	public SubCategory updateSubCategory(Integer subCategoryId, SubCategory updatedSubCategory) throws GlobalException;

	public void deleteSubCategory(Integer subCategoryId) throws GlobalException;


	public SubCategory setCategoryidToSubCategory(Integer subCategoryId, Integer catgoryid) throws GlobalException;





}
