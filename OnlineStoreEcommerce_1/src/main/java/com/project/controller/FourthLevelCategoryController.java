package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.FourthLevelCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.service.FourthLevelCategoryService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FourthLevelCategoryController {
	
	
	@Autowired
    private FourthLevelCategoryService fourthLevelCategoryService;
	
    @PostMapping("/createFourthLevelCategories")
    public ResponseEntity<String> createFourthLevelCategory(@Valid @RequestBody FourthLevelCategory FourthLevelCategory) {
		FourthLevelCategory createdFourthLevelCategory = fourthLevelCategoryService.createFourthLevelCategory(FourthLevelCategory);
        if (createdFourthLevelCategory!= null) 
        {
            return new ResponseEntity<>("FourthLevelCategories Added Successfully", HttpStatus.CREATED);
        } 
        else 
        {
            return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
	 @GetMapping("/getAllFourthLevelCategories")
	    public ResponseEntity<List<FourthLevelCategory>> getAllSubSubCategories() {
	    List<FourthLevelCategory> FourthLevelCategories = fourthLevelCategoryService.getAllFourthLevelCategories();
	    return new ResponseEntity<>(FourthLevelCategories, HttpStatus.OK);
     }
	 
	 
	 //forcategoryid
	 
	 @PutMapping("/setcategoryidToFourthLevelCategory/{fourthlevelcategoryId}/{categoryid}")
	  public FourthLevelCategory setcategoryidToFourthLevelCategory(@PathVariable("fourthlevelcategoryId") Integer fourthlevelcategoryId,@PathVariable("categoryid") Integer categoryid) throws GlobalException 
	  {
		return fourthLevelCategoryService.setcategoryidToFourthLevelCategory(fourthlevelcategoryId,categoryid);
		  
	  }
	 
	 //forsubcategoryid
	 
	 @PutMapping("/setsubcategoryidToFourthLevelCategory/{fourthlevelcategoryId}/{subcategoryid}")
	  public FourthLevelCategory setsubcategoryidToFourthLevelCategory(@PathVariable("fourthlevelcategoryId") Integer fourthlevelcategoryId,@PathVariable("subcategoryid") Integer subcategoryid) throws GlobalException 
	  {
		return fourthLevelCategoryService.setsubcategoryidToFourthLevelCategory(fourthlevelcategoryId,subcategoryid);
		  
	  }
	 
	 //forsubsubcategory id
	 @PutMapping("/setsubSubCategoryIdToFourthLevelCategory/{fourthlevelcategoryId}/{subSubCategoryId}")
	  public FourthLevelCategory setsubSubCategoryIdToFourthLevelCategory(@PathVariable("fourthlevelcategoryId") Integer fourthlevelcategoryId,@PathVariable("subSubCategoryId") Integer subSubCategoryId) throws GlobalException 
	  {
		return fourthLevelCategoryService.setsubSubCategoryIdToFourthLevelCategory(fourthlevelcategoryId,subSubCategoryId);
		  
	  }

	 @GetMapping("/getFourthLevelCategoryById/{fourthlevelcategoryId}")
	 public ResponseEntity<FourthLevelCategory> getFourthLevelCategoryById(@PathVariable Integer fourthlevelcategoryId) throws GlobalException {
	     FourthLevelCategory FourthLevelCategory = fourthLevelCategoryService. getFourthlevelcategoryId(fourthlevelcategoryId);
	     if (FourthLevelCategory != null) {
	         return new ResponseEntity<>(FourthLevelCategory, HttpStatus.OK);
	     } else {
	         throw new GlobalException("FourthLevelCategory with ID " + fourthlevelcategoryId + " not found");
	     }
	 }
	 
	 @PutMapping("/updateFourthLevelCategory/{fourthlevelcategoryId}/{categoryid}/{subcategoryId}/{subSubCategoryId}")
	    public ResponseEntity<String> updateFourthLevelCategory(@PathVariable Integer fourthlevelcategoryId,@PathVariable Integer categoryid, @PathVariable Integer subcategoryId, @PathVariable Integer subSubCategoryId, @RequestBody FourthLevelCategory updatedFourthLevelCategory) throws GlobalException {
	        FourthLevelCategory fourthLevelCategory = fourthLevelCategoryService.updateFourthLevelCategory(fourthlevelcategoryId, categoryid,subcategoryId,subSubCategoryId, updatedFourthLevelCategory);
	        if (fourthLevelCategory != null) {
	            return new ResponseEntity<>("FourthLevelCategory Updated Successfully", HttpStatus.OK);
	        } else {
	            throw new GlobalException("FourthLevelCategory with ID " + fourthlevelcategoryId + " not found");
	        }
	    }
	 
	 
	 @DeleteMapping("/deleteFourthLevelCategory/{fourthlevelcategoryId}")
	    public ResponseEntity<String> deleteFourthLevelCategory(@PathVariable Integer fourthlevelcategoryId) throws GlobalException {
	        fourthLevelCategoryService.deleteFourthLevelCategory(fourthlevelcategoryId);
	        return new ResponseEntity<>("FourthLevelCategory with ID " + fourthlevelcategoryId + " deleted successfully", HttpStatus.OK);
	    }
	 

	 @PutMapping("/setSubSubCategoryidToFourthLevelCategory/{FourthLevelCategoryId}/{SubSubCategoryId}")
	  public FourthLevelCategory setSubSubCategoryidToFourthLevelCategory(@PathVariable("FourthLevelCategoryId") Integer FourthLevelCategoryId,@PathVariable("subsubcategoryid") Integer subsubcategoryid) throws GlobalException 
	  {
		return fourthLevelCategoryService.setSubSubCategoryidToFourthLevelCategory(FourthLevelCategoryId,subsubcategoryid);
	  }
}
