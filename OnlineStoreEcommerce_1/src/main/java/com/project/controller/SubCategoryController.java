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

import com.project.dao.Category;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.service.CategoryService;
import com.project.service.SubCategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SubCategoryController {
	
	@Autowired
	private CategoryService categoryService;
   
	@Autowired
	private SubCategoryService subCategoryService;
	
	@PostMapping("/createSubCategories")
    public ResponseEntity<String> createSubCategory(@Valid @RequestBody SubCategory subcategory) {
        SubCategory createdSubCategory = subCategoryService.createSubCategory(subcategory);
        if (createdSubCategory!= null) 
        {
            return new ResponseEntity<>("SubCategory Added Successfully", HttpStatus.CREATED);
        } 
        else 
        {
            return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
     }
	 @GetMapping("/getAllSubCategories")
	    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
	    List<SubCategory> subCategories = subCategoryService.getAllSubCategories();
	      return new ResponseEntity<>(subCategories, HttpStatus.OK);
      }
	 
	 @GetMapping("/getSubCategoryById/{subCategoryId}")
	 public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Integer subCategoryId) throws GlobalException {
	     SubCategory subcategory = subCategoryService.getSubCategoryById(subCategoryId);
	     if (subcategory != null) {
	         return new ResponseEntity<>(subcategory, HttpStatus.OK);
	     } else {
	         throw new GlobalException("SubCategory with ID " + subCategoryId + " not found");
	     }
	 }
	 
	
	 
	 @PutMapping("/updateSubCategory/{subCategoryId}")
	    public ResponseEntity<String> updateSubCategory(@PathVariable Integer subCategoryId, @RequestBody SubCategory updatedSubCategory) throws GlobalException {
	        SubCategory subCategory = subCategoryService.updateSubCategory(subCategoryId, updatedSubCategory);
	        if (subCategory != null) {
	            return new ResponseEntity<>("SubCategory Updated Successfully", HttpStatus.OK);
	        } else {
	            throw new GlobalException("SubCategory with ID " + subCategoryId + " not found");
	        }
	    }
	 
	 @DeleteMapping("/deleteSubCategory/{subCategoryId}")
	    public ResponseEntity<String> deleteSubCategory(@PathVariable Integer subCategoryId) throws GlobalException {
	        subCategoryService.deleteSubCategory(subCategoryId);
	        return new ResponseEntity<>("SubCategory with ID " + subCategoryId + " deleted successfully", HttpStatus.OK);
	    }
	 

	 @PutMapping("/setCategoryidToSubCategory/{subCategoryId}/{categoryid}")
	 public ResponseEntity<String> setCategoryidToSubCategory(@PathVariable("subCategoryId") Integer subCategoryId, @PathVariable("categoryid") Integer categoryid) throws GlobalException {
	     SubCategory updatedSubCategory = subCategoryService.setCategoryidToSubCategory(subCategoryId, categoryid);
	     if (updatedSubCategory != null) {
	         return new ResponseEntity<>("Category ID Updated Successfully", HttpStatus.OK);
	     } else {
	         throw new GlobalException("SubCategory with ID " + subCategoryId + " not found");
	     }
	 }


	

	 
}
