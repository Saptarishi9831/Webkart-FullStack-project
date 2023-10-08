package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.Category;
import com.project.dao.ImageFourthCategory;
import com.project.dao.SubCategory;
import com.project.error.GlobalException;
import com.project.service.ImageFourthCategoryService;

@RestController
public class ImageFourthCategoryController {
	
	@Autowired
	private ImageFourthCategoryService imageFourthCategoryService;
	
	@PostMapping("/uploadImage")
	public ResponseEntity<String> createImage(@RequestBody ImageFourthCategory imageFourthCatgeory) {
	    try {
	        ImageFourthCategory createdImage = imageFourthCategoryService.createImage(imageFourthCatgeory);
	        if (createdImage != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body("Image Added Successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Add Image");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
}
	 @GetMapping("/getAllFourthCategoryImage")
	    public ResponseEntity<List<ImageFourthCategory>> getAllFourthCategoryImage() 
	 {
	        List<ImageFourthCategory> getImages = imageFourthCategoryService.getAllFourthCategoryImage();
	        return new ResponseEntity<>(getImages, HttpStatus.OK);
	 }
	 
	 @GetMapping("/getAllFourthCategoryImageById/{imageFourthId}")
	    public ResponseEntity<ImageFourthCategory> getAllFourthCategoryImageById(@PathVariable Integer imageFourthId) throws GlobalException {
		 ImageFourthCategory imageFourthCategory = imageFourthCategoryService.getAllFourthCategoryImageById(imageFourthId);
	        if (imageFourthCategory != null) {
	            return new ResponseEntity<>(imageFourthCategory, HttpStatus.OK);
	        } else {
	            throw new GlobalException("Image with ID " + imageFourthId + " not found");
	        }
	    }
	 
	 @PutMapping("/updateImageFourthCategory/{imageFourthId}")
	    public ResponseEntity<String> updateImageFourthCategory(@PathVariable Integer imageFourthId, @RequestBody ImageFourthCategory updatedImageFourthCategory) throws GlobalException {
		 ImageFourthCategory imageFourthCategory = imageFourthCategoryService.updateImageFourthCategory(imageFourthId, updatedImageFourthCategory);
	        if (imageFourthCategory != null) {
	            return new ResponseEntity<>("Image Updated Successfully", HttpStatus.OK);
	        } else {
	            throw new GlobalException("Image with ID " + imageFourthId + " not found");
	        }
	    }

	    @DeleteMapping("/deleteImageFourthCategory/{imageFourthId}")
	    public ResponseEntity<String> deleteImageFourthCategory(@PathVariable Integer imageFourthId) throws GlobalException {
	    	imageFourthCategoryService.deleteImageFourthCategory(imageFourthId);
	        return new ResponseEntity<>("Image with ID " + imageFourthId + " deleted successfully", HttpStatus.OK);
	    }
	    
	    @PutMapping("/setFourthCategoryidToImageCategory/{imageFourthId}/{fourthlevelcategoryId}")
		  public ImageFourthCategory setFourthCategoryidToImageCategory(@PathVariable("imageFourthId") Integer imageFourthId,@PathVariable("fourthlevelcategoryId") Integer fourthlevelcategoryId) throws GlobalException 
		  {
			return imageFourthCategoryService.setFourthCategoryidToImageCategory(imageFourthId,fourthlevelcategoryId);
			  
		  }
}