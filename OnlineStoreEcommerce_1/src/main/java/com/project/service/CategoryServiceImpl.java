package com.project.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dao.Category;
import com.project.dao.FourthLevelCategory;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.repository.CategoryRepository;
import com.project.repository.SubCategoryRepository;
import com.project.repository.SubSubCategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    

    @Autowired
    private  SubCategoryRepository subCategoryRepository;
    
    @Autowired
    private  SubSubCategoryRepository  subSubCategoryRepository;

    // Create a new category
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Retrieve all categories
	@Override
	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
	}
    
	// Retrieve a category by its ID
	@Override
	public Category getCategoryById(Integer categoryid) throws GlobalException {
		
		Optional<Category> cate=categoryRepository.findById(categoryid);
		Category cate1=null;
		if(!cate.isPresent()) 
		{
			throw new GlobalException("Category with id "+ categoryid+" not found");
		}else {
			cate1=categoryRepository.findById(categoryid).get();
			return cate1;
		}
	}

	// Update a category by its ID
	@Override
	public Category updateCategory(Integer categoryid, Category updatedCategory) throws GlobalException {
	 Optional<Category> categoryOptional = categoryRepository.findById(categoryid);
	 if (!categoryOptional.isPresent())
     {
		   throw new GlobalException("Category with id " + categoryid + " not found");
     }
		    Category existingCategory = categoryOptional.get();
		    existingCategory.setCategoryName(updatedCategory.getCategoryName());
		    return categoryRepository.save(existingCategory);
	 }
    
	// Delete a category by its ID
	@Override
	public void deleteCategory(Integer categoryid) throws GlobalException 
	{
	 Optional<Category> categoryOptional = categoryRepository.findById(categoryid);
	 if (!categoryOptional.isPresent())
	 {
	       throw new GlobalException("Category with id " + categoryid + " not found");
	  }
	        categoryRepository.deleteById(categoryid);
	  }

	@Override
	public List<SubCategory> getSubcategoriesByCategoryId(Integer categoryid) throws GlobalException {
		 Category category = categoryRepository.findById(categoryid)
                 .orElseThrow(() -> new GlobalException("Category not found"));
        return category.getSubCategories();
	}

	@Override
	public List<SubSubCategory> getSubSubCategoriesBySubcategoryId(Integer subcategoryId) {
		
		 Optional<SubCategory> subCategory = subCategoryRepository.findById(subcategoryId);
	        if (subCategory.isPresent()) {
	            return subCategory.get().getSubSubCategories();
	        }
	        return new ArrayList<>();
	}

	@Override
	public List<FourthLevelCategory> getFourthLevelCategoriesBySubSubcategoryId(Integer subSubCategoryId) {
		
		 Optional<SubSubCategory> subSubCategory = subSubCategoryRepository.findById(subSubCategoryId);
	        if (subSubCategory.isPresent()) {
	            return subSubCategory.get().getFourthLevelCategories();
	        }
	        return new ArrayList<>();
	}

}


		
		
	







