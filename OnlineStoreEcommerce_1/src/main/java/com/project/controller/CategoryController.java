package com.project.controller;
import java.util.ArrayList;
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

import com.project.dao.Category;
import com.project.dao.FourthLevelCategory;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.service.CategoryService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    //Add Categories(localhost:8888/createCategories)
    @PostMapping("/createCategories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        if (createdCategory != null) 
        {
            return new ResponseEntity<>("Category Added Successfully", HttpStatus.CREATED);
        } 
        else 
        {
            return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
     }
    //Get All Categories(localhost:8888/getAllCategories)
    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Get Categories By Id(localhost:8888/getCategoryById/{categoryid}")
    @GetMapping("/getCategoryById/{categoryid}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryid) throws GlobalException {
        Category category = categoryService.getCategoryById(categoryid);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            throw new GlobalException("Category with ID " + categoryid + " not found");
        }
    }
    
    @GetMapping("/subcategories/{categoryid}")
    public ResponseEntity<List<SubCategory>> getSubcategoriesByCategoryId(@PathVariable Integer categoryid) throws GlobalException {
        List<SubCategory> subcategories = categoryService.getSubcategoriesByCategoryId(categoryid);
        return ResponseEntity.ok(subcategories);
    }
    @GetMapping("/subcategories/{subcategoryId}/subsubcategories")
    public ResponseEntity<List<Map<String, Object>>> getSubSubCategoriesBySubcategoryId(@PathVariable Integer subcategoryId) {
        List<SubSubCategory> subsubcategories = categoryService.getSubSubCategoriesBySubcategoryId(subcategoryId);
        List<Map<String, Object>> response = new ArrayList<>();
        for (SubSubCategory subsubCategory : subsubcategories) {
            Map<String, Object> subsubCategoryMap = new HashMap<>();
            subsubCategoryMap.put("subSubCategoryId", subsubCategory.getSubSubCategoryId());
            subsubCategoryMap.put("subSubCategoryName", subsubCategory.getSubSubCategoryName());
            subsubCategoryMap.put("subcategoryId", subsubCategory.getSubcategory().getSubCategoryId());
            subsubCategoryMap.put("categoryId", subsubCategory.getSubcategory().getCategory().getCategoryid());
            response.add(subsubCategoryMap);
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/subsubcategories/{subSubCategoryId}/fourthlevelcategories")
    public ResponseEntity<List<Map<String, Object>>> getFourthLevelCategoriesBySubSubcategoryId(@PathVariable Integer subSubCategoryId) {
        List<FourthLevelCategory> fourthLevelCategories = categoryService.getFourthLevelCategoriesBySubSubcategoryId(subSubCategoryId);
        List<Map<String, Object>> response = new ArrayList<>();
        for (FourthLevelCategory fourthLevelCategory : fourthLevelCategories) {
            Map<String, Object> fourthLevelCategoryMap = new HashMap<>();
            fourthLevelCategoryMap.put("fourthLevelCategoryId", fourthLevelCategory.getFourthlevelcategoryId());
            fourthLevelCategoryMap.put("fourthlevelcategoryname", fourthLevelCategory.getFourthlevelcategoryname());
            fourthLevelCategoryMap.put("subSubCategoryId", fourthLevelCategory.getSubSubCategory().getSubSubCategoryId());
            fourthLevelCategoryMap.put("subcategoryId", fourthLevelCategory.getSubSubCategory().getSubcategory().getSubCategoryId());
            fourthLevelCategoryMap.put("categoryId", fourthLevelCategory.getSubSubCategory().getSubcategory().getCategory().getCategoryid());
            response.add(fourthLevelCategoryMap);
        }
        return ResponseEntity.ok(response);
    }

    
    //Put Categories By Id(localhost:8888/updateCategory/{categoryid}")
    @PutMapping("/updateCategory/{categoryid}")
    public ResponseEntity<String> updateCategory(@PathVariable Integer categoryid, @RequestBody Category updatedCategory) throws GlobalException {
        Category category = categoryService.updateCategory(categoryid, updatedCategory);
        if (category != null) {
            return new ResponseEntity<>("Category Updated Successfully", HttpStatus.OK);
        } else {
            throw new GlobalException("Category with ID " + categoryid + " not found");
        }
    }

    @DeleteMapping("/deleteCategory/{categoryid}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryid) throws GlobalException {
        categoryService.deleteCategory(categoryid);
        return new ResponseEntity<>("Category with ID " + categoryid + " deleted successfully", HttpStatus.OK);
    }
    
}

    

    



