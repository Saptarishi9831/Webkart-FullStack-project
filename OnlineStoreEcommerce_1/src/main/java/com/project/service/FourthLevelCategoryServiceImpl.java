package com.project.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.Category;
import com.project.dao.FourthLevelCategory;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.repository.CategoryRepository;
import com.project.repository.FourthLevelCategoryRepository;
import com.project.repository.SubCategoryRepository;
import com.project.repository.SubSubCategoryRepository;

@Service
public class FourthLevelCategoryServiceImpl implements FourthLevelCategoryService{

	@Autowired
	private FourthLevelCategoryRepository fourthLevelCategoryRepository;

	@Autowired
	private SubSubCategoryRepository subSubCategoryRepository;
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public FourthLevelCategory createFourthLevelCategory(@Valid FourthLevelCategory fourthLevelCategory) {
		return fourthLevelCategoryRepository.save(fourthLevelCategory);
	}

//categoryid
	@Override
	public FourthLevelCategory setcategoryidToFourthLevelCategory (Integer fourthlevelcategoryId, Integer categoryid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<FourthLevelCategory> sub = fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("Fourthlevelcategory not exist " + fourthlevelcategoryId);
	    }
	    Optional<Category> cate = categoryRepository.findById(categoryid);
	    if (!cate.isPresent()) {
	        throw new GlobalException("Category not exist " + categoryid);
	    }
	    FourthLevelCategory sub1 = fourthLevelCategoryRepository.findById(fourthlevelcategoryId).get();
	    Category cate1 = categoryRepository.findById(categoryid).get();

	    if (sub1!= null) {
	        sub1.setCategory(cate1);
	    }

	    return fourthLevelCategoryRepository.save(sub1);
	}
	
	//subcategoryid
	@Override
	public FourthLevelCategory setsubcategoryidToFourthLevelCategory (Integer fourthlevelcategoryId, Integer subcategoryid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<FourthLevelCategory> sub = fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("Fourthlevelcategory not exist " + fourthlevelcategoryId);
	    }
	    Optional<SubCategory> cate =  subCategoryRepository.findById(subcategoryid);
	    if (!cate.isPresent()) {
	        throw new GlobalException("SubCategory not exist " + subcategoryid);
	    }
	    FourthLevelCategory sub1 = fourthLevelCategoryRepository.findById(fourthlevelcategoryId).get();
	    SubCategory cate1 = subCategoryRepository.findById(subcategoryid).get();

	    if (sub1 != null) {
	        sub1.setSubcategory(cate1);
	    }
	    return fourthLevelCategoryRepository.save(sub1);
	}
	
	//subsubcategoryid
	@Override
	public FourthLevelCategory setsubSubCategoryIdToFourthLevelCategory (Integer fourthlevelcategoryId, Integer subSubCategoryId) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<FourthLevelCategory> sub = fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("fourthlevelcategory not exist " + fourthlevelcategoryId);
	    }

	    Optional<SubSubCategory> cate = subSubCategoryRepository.findById(subSubCategoryId);
	    if (!cate.isPresent()) {
	        throw new GlobalException("SubSubCategory not exist " + subSubCategoryId);
	    }

	    FourthLevelCategory sub1 = fourthLevelCategoryRepository.findById(fourthlevelcategoryId).get();
	    SubSubCategory cate1 = subSubCategoryRepository.findById(subSubCategoryId).get();

	    if (sub1 != null) {
	        sub1.setSubSubCategory(cate1);
	    }

	    return fourthLevelCategoryRepository.save(sub1);
	}

	@Override
	public List<FourthLevelCategory> getAllFourthLevelCategories() {
		// TODO Auto-generated method stub
		return fourthLevelCategoryRepository.findAll();
	}

	

	@Override
	public void deleteFourthLevelCategory(Integer fourthlevelcategoryId) throws GlobalException {
		// TODO Auto-generated method stub
		 Optional<FourthLevelCategory> fourthLevelCategoryOptional = fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
		 if (!fourthLevelCategoryOptional.isPresent())
		 {
		       throw new GlobalException("FourthLevelCategory with id " + fourthlevelcategoryId + " not found");
		  }
		 		fourthLevelCategoryRepository.deleteById(fourthlevelcategoryId);
		  
	}

	@Override
	public FourthLevelCategory setSubSubCategoryidToFourthLevelCategory(Integer fourthLevelCategoryId,Integer categoryid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<FourthLevelCategory> sub = fourthLevelCategoryRepository.findById(fourthLevelCategoryId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("FourthLevelCategory not exist " + fourthLevelCategoryId);
	    }

	    Optional<Category> cate = categoryRepository.findById(categoryid);
	    if (!cate.isPresent()) {
	        throw new GlobalException("Category not exist " + categoryid);
	    }

	    FourthLevelCategory sub1 = fourthLevelCategoryRepository.findById(fourthLevelCategoryId).get();
	    Category cate1 = categoryRepository.findById(categoryid).get();

    if (sub1 != null) {
	        sub1.setCategory(cate1);
	    }
	    return fourthLevelCategoryRepository.save(sub1);
	}

	@Override
	public FourthLevelCategory getFourthlevelcategoryId(Integer fourthLevelCategoryId) throws GlobalException {
		Optional<FourthLevelCategory> subcate=fourthLevelCategoryRepository.findById(fourthLevelCategoryId);
		FourthLevelCategory subcate1=null;
		if(!subcate.isPresent()) 
		{
			throw new GlobalException("FourthLevelCategoryId with id "+ fourthLevelCategoryId+" not found");
		}else {
			subcate1=fourthLevelCategoryRepository.findById(fourthLevelCategoryId).get();
			return subcate1;
		}
	}

	@Override
	public FourthLevelCategory updateFourthLevelCategory(Integer fourthlevelcategoryId, Integer categoryid,
			Integer subcategoryId, Integer subSubCategoryId, FourthLevelCategory updatedFourthLevelCategory) throws GlobalException {
	    Optional<FourthLevelCategory> fourthLevelCategoryOptional = fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
	    if (fourthLevelCategoryOptional.isPresent()) {
	        FourthLevelCategory fourthLevelCategory = fourthLevelCategoryOptional.get();
	        Category category = categoryRepository.findById(categoryid).orElse(null);
	        if (category == null) {
	            throw new GlobalException("Category with id " + categoryid + " not found");
	        }
	        fourthLevelCategory.setCategory(category);

	        SubCategory subCategory = subCategoryRepository.findById(subcategoryId).orElse(null);
	        if (subCategory == null) {
	            throw new GlobalException("SubCategory with id " + subcategoryId + " not found");
	        }
	        fourthLevelCategory.setSubcategory(subCategory);

	        
	        SubSubCategory subSubCategory = subSubCategoryRepository.findById(subSubCategoryId).orElse(null);
	        if (subSubCategory == null) {
	            throw new GlobalException("SubSubCategory with id " + subSubCategoryId + " not found");
	        }
	        fourthLevelCategory.setSubSubCategory(subSubCategory);

	        fourthLevelCategory.setFourthlevelcategoryname(updatedFourthLevelCategory.getFourthlevelcategoryname());
	        fourthLevelCategory.setProducts(updatedFourthLevelCategory.getProducts());
	        fourthLevelCategory.setImages(updatedFourthLevelCategory.getImages());

	        // Save and return the updated fourth level category
	        return fourthLevelCategoryRepository.save(fourthLevelCategory);
	    } else {
	        throw new GlobalException("FourthLevelCategory with id " +fourthlevelcategoryId + " not found");
	    }
	}

}


	

	

	
	


	
