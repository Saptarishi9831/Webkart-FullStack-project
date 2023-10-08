package com.project.service;

import java.util.List;
import javax.validation.Valid;
import com.project.dao.Category;
import com.project.dao.FourthLevelCategory;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;

public interface CategoryService {
	public Category createCategory(@Valid Category category);

	public List<Category> getAllCategories();

	public Category getCategoryById(Integer categoryid)throws GlobalException;

	public Category updateCategory(Integer categoryid, Category updatedCategory) throws GlobalException;

	public void deleteCategory(Integer categoryid) throws GlobalException;

	public List<SubCategory> getSubcategoriesByCategoryId(Integer categoryid) throws GlobalException;

	public List<SubSubCategory> getSubSubCategoriesBySubcategoryId(Integer subcategoryId);

	public List<FourthLevelCategory> getFourthLevelCategoriesBySubSubcategoryId(Integer subSubCategoryId);

	
}
