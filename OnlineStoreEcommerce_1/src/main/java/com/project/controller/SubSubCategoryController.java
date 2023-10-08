package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.service.CategoryService;
import com.project.service.SubCategoryService;
import com.project.service.SubSubCategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SubSubCategoryController {
	@Autowired
	private CategoryService categoryService;
	

	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
    private SubSubCategoryService subSubCategoryService;
	
	
    @PostMapping("/createSubSubCategories")
    public ResponseEntity<String> createSubSubCategory(@Valid @RequestBody SubSubCategory subsubcategory) {
		SubSubCategory createdSubSubCategory = subSubCategoryService.createSubSubCategory(subsubcategory);
        if (createdSubSubCategory!= null) 
        {
            return new ResponseEntity<>("SubSubCategory Added Successfully", HttpStatus.CREATED);
        } 
        else 
        {
            return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
     }
    @PutMapping("/setCategoryidToSubSubCategory/{subSubCategoryId}/{categoryid}")
    public SubSubCategory setCategoryidToSubSubCategory(
            @PathVariable("subSubCategoryId") Integer subSubCategoryId,
            @PathVariable("categoryid") Integer categoryid) throws GlobalException {
            return subSubCategoryService.setsubcategoryidToSubSubCategory(subSubCategoryId, categoryid);
        }

    
    //for subcategoryid
    @PutMapping("/setsubcategoryidToSubSubCategory/{subSubCategoryId}/{subcategoryId}")
    public SubSubCategory setsubcategoryidToSubSubCategory(
        @PathVariable("subSubCategoryId") Integer subSubCategoryId,
        @PathVariable("subcategoryId") Integer subcategoryId) throws GlobalException {
        return subSubCategoryService.setsubcategoryidToSubSubCategory(subSubCategoryId, subcategoryId);
    }



	 @GetMapping("/getAllSubSubCategories")
	    public ResponseEntity<List<SubSubCategory>> getAllSubSubCategories() {
	    List<SubSubCategory> subSubCategories = subSubCategoryService.getAllSubSubCategories();
	    return new ResponseEntity<>(subSubCategories, HttpStatus.OK);
     }

	 @GetMapping("/getSubSubCategoryById/{subSubCategoryId}")
	 public ResponseEntity<SubSubCategory> getSubSubCategoryById(@PathVariable Integer subSubCategoryId) throws GlobalException {
	     SubSubCategory subsubcategory = subSubCategoryService.getSubSubCategoryById(subSubCategoryId);
	     if (subsubcategory != null) {
	         return new ResponseEntity<>(subsubcategory, HttpStatus.OK);
	     } else {
	         throw new GlobalException("SubSubCategory with ID " + subSubCategoryId + " not found");
	     }
	 }
	 
	 @PutMapping("/updateSubSubCategory/{subSubCategoryId}/{categoryid}/{subcategoryId}")
	    public ResponseEntity<String> updateSubSubCategory(@PathVariable Integer subSubCategoryId,@PathVariable Integer categoryid, @PathVariable Integer subcategoryId,@RequestBody SubSubCategory updatedSubSubCategory) throws GlobalException {
	        SubSubCategory subSubCategory = subSubCategoryService.updateSubSubCategory(subSubCategoryId, categoryid,subcategoryId, updatedSubSubCategory);
	        if (subSubCategory != null) {
	            return new ResponseEntity<>("SubSubCategory Updated Successfully", HttpStatus.OK);
	        } else {
	            throw new GlobalException("SubSubCategory with ID " + subSubCategoryId + " not found");
	        }
	    }
	 
	 @DeleteMapping("/deleteSubSubCategory/{subSubCategoryId}")
	    public ResponseEntity<String> deleteSubSubCategory(@PathVariable Integer subSubCategoryId) throws GlobalException {
	        subSubCategoryService.deleteSubSubCategory(subSubCategoryId);
	        return new ResponseEntity<>("SubCategory with ID " + subSubCategoryId + " deleted successfully", HttpStatus.OK);
	    }
	 
	
}