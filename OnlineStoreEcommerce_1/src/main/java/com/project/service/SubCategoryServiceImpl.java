package com.project.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.Category;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.repository.CategoryRepository;
import com.project.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public SubCategory createSubCategory(@Valid SubCategory subcategory) {
		
		return subCategoryRepository.save(subcategory);
	}

	@Override
	public List<SubCategory> getAllSubCategories() {
		return subCategoryRepository.findAll();
	}

	@Override
	public SubCategory getSubCategoryById(Integer subCategoryId) throws GlobalException {
		
		Optional<SubCategory> subcate=subCategoryRepository.findById(subCategoryId);
		SubCategory subcate1=null;
		if(!subcate.isPresent()) 
		{
			throw new GlobalException("SubCategory with id "+ subCategoryId+" not found");
		}else {
			subcate1=subCategoryRepository.findById(subCategoryId).get();
			return subcate1;
		}
	}

	@Override
	public SubCategory updateSubCategory(Integer subCategoryId, SubCategory updatedSubCategory) throws GlobalException 
	{
		 Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(subCategoryId);
		 if (!subCategoryOptional.isPresent())
	     {
			   throw new GlobalException("SubCategory with id " + subCategoryId + " not found");
	     }
			    SubCategory existingCategory = subCategoryOptional.get();
			    existingCategory.setSubCategoryName(updatedSubCategory.getSubCategoryName());
			    return subCategoryRepository.save(existingCategory);
		 }

	@Override
	public void deleteSubCategory(Integer subCategoryId) throws GlobalException {
		 Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(subCategoryId);
		 if (!subCategoryOptional.isPresent())
		 {
		       throw new GlobalException("SubCategory with id " + subCategoryId + " not found");
		  }
		        subCategoryRepository.deleteById(subCategoryId);
		  }

	@Override
	public SubCategory setCategoryidToSubCategory(Integer subCategoryId, Integer categoryid) throws GlobalException {
		    Optional<SubCategory> sub = subCategoryRepository.findById(subCategoryId);
		    if (!sub.isPresent()) {
		        throw new GlobalException("SubCategory not exist " + subCategoryId);
		    }

		    Optional<Category> cate = categoryRepository.findById(categoryid);
		    if (!cate.isPresent()) {
		        throw new GlobalException("Category not exist " + categoryid);
		    }

		    SubCategory sub1 = subCategoryRepository.findById(subCategoryId).get();
		    Category cate1 = categoryRepository.findById(categoryid).get();

		    if (sub1 != null) {
		        sub1.setCategory(cate1);
		    }

		    return subCategoryRepository.save(sub1);
		}

	
	

	}



	



		
	
