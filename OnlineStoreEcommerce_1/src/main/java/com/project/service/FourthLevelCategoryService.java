package com.project.service;

import java.util.List;

import javax.validation.Valid;

import com.project.dao.FourthLevelCategory;
import com.project.error.GlobalException;

public interface FourthLevelCategoryService {

	public FourthLevelCategory createFourthLevelCategory(@Valid FourthLevelCategory fourthLevelCategory);

	public List<FourthLevelCategory> getAllFourthLevelCategories();

	public FourthLevelCategory setcategoryidToFourthLevelCategory(Integer fourthlevelcategoryId, Integer categoryid) throws GlobalException;;

	public FourthLevelCategory setsubcategoryidToFourthLevelCategory(Integer fourthlevelcategoryId,Integer subcategoryid) throws GlobalException;

	public FourthLevelCategory setsubSubCategoryIdToFourthLevelCategory(Integer fourthlevelcategoryId,Integer subSubCategoryId) throws GlobalException;

FourthLevelCategory setSubSubCategoryidToFourthLevelCategory(Integer fourthLevelCategoryId, Integer categoryid) throws GlobalException;

public FourthLevelCategory getFourthlevelcategoryId(Integer fourthLevelCategoryId) throws GlobalException;

public void deleteFourthLevelCategory(Integer fourthlevelcategoryId) throws GlobalException;

public FourthLevelCategory updateFourthLevelCategory(Integer fourthlevelcategoryId, Integer categoryid,
		Integer subcategoryId, Integer subSubCategoryId, FourthLevelCategory updatedFourthLevelCategory) throws GlobalException;











}
