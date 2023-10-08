package com.project.service;

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
import com.project.repository.SubSubCategoryRepository;

@Service
public class SubSubCategoryServiceImpl implements SubSubCategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubSubCategoryRepository subSubCategoryRepository;
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public SubSubCategory createSubSubCategory(@Valid SubSubCategory subsubcategory) {
		// TODO Auto-generated method stub
		return subSubCategoryRepository.save(subsubcategory);
	}
	

	@Override
	public SubSubCategory setCategoryidToSubSubCategory (Integer subSubCategoryId, Integer categoryid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<SubSubCategory> sub = subSubCategoryRepository.findById(subSubCategoryId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("SubSubCategory not exist " + subSubCategoryId);
	    }

	    Optional<Category> cate = categoryRepository.findById(categoryid);
	    if (!cate.isPresent()) {
	        throw new GlobalException("Category not exist " + categoryid);
	    }

	    SubSubCategory sub1 = subSubCategoryRepository.findById(subSubCategoryId).get();
	    Category cate1 = categoryRepository.findById(categoryid).get();

	    if (sub1 != null) {
	        sub1.setCategory(cate1);
	    }

	    return subSubCategoryRepository.save(sub1);
	}
//subcate



	@Override
	public List<SubSubCategory> getAllSubSubCategories() {
		// TODO Auto-generated method stub
		return subSubCategoryRepository.findAll();
	}
	


	@Override
	public SubSubCategory getSubSubCategoryById(Integer subSubCategoryId) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<SubSubCategory> subsubcate=subSubCategoryRepository.findById(subSubCategoryId);
		SubSubCategory subsubcate1=null;
		if(!subsubcate.isPresent()) 
		{
			throw new GlobalException("SubCategory with id "+ subSubCategoryId+" not found");
		}else {
			subsubcate1=subSubCategoryRepository.findById(subSubCategoryId).get();
			return subsubcate1;
		}
	}

	@Override
	public SubSubCategory updateSubSubCategory(Integer subSubCategoryId, Integer categoryid, Integer subcategoryId, SubSubCategory updatedSubSubCategory) throws GlobalException {
	    Optional<SubSubCategory> subSubCategoryOptional = subSubCategoryRepository.findById(subSubCategoryId);
	    if (subSubCategoryOptional.isPresent()) {
	        SubSubCategory subSubCategory = subSubCategoryOptional.get();

	        // Update subcategory
	        SubCategory subCategory = subCategoryRepository.findById(subcategoryId).orElse(null);
	        if (subCategory == null) {
	            throw new GlobalException("SubCategory with id " + subcategoryId + " not found");
	        }
	        subSubCategory.setSubcategory(subCategory);

	        // Update category
	        Category category = categoryRepository.findById(categoryid).orElse(null);
	        if (category == null) {
	            throw new GlobalException("Category with id " + categoryid + " not found");
	        }
	        subSubCategory.setCategory(category);

	        // Update subSubCategoryName
	        subSubCategory.setSubSubCategoryName(updatedSubSubCategory.getSubSubCategoryName());

	        // Save and return the updated subSubCategory
	        return subSubCategoryRepository.save(subSubCategory);
	    } else {
	        throw new GlobalException("SubSubCategory with id " + subSubCategoryId + " not found");
	    }
	}


	@Override
	public void deleteSubSubCategory(Integer subSubCategoryId) throws GlobalException {
		 Optional<SubSubCategory> subSubCategoryOptional = subSubCategoryRepository.findById(subSubCategoryId);
		 if (!subSubCategoryOptional.isPresent())
		 {
		       throw new GlobalException("SubCategory with id " + subSubCategoryId + " not found");
		  }
		        subSubCategoryRepository.deleteById(subSubCategoryId);
		  }


	@Override
	public SubSubCategory setsubcategoryidToSubSubCategory(Integer subSubCategoryId, Integer subcategoryId) throws GlobalException {
		Optional<SubSubCategory> sub = subSubCategoryRepository.findById(subSubCategoryId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("SubSubCategory not exist " + subSubCategoryId);
	    }

	    Optional<SubCategory> cate =  subCategoryRepository.findById(subcategoryId);
	    if (!cate.isPresent()) {
	        throw new GlobalException("SubCategory not exist " + subcategoryId);
	    }

	    SubSubCategory sub1 = subSubCategoryRepository.findById(subSubCategoryId).get();
	    SubCategory cate1 = subCategoryRepository.findById(subcategoryId).get();

	    if (sub1 != null) {
	        sub1.setSubcategory(cate1);
	    }

	    return subSubCategoryRepository.save(sub1);
	}



}


	
	

	


