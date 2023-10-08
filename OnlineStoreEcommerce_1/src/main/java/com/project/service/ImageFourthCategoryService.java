package com.project.service;

import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.project.dao.ImageFourthCategory;
import com.project.dao.SubCategory;
import com.project.error.GlobalException;

public interface ImageFourthCategoryService {

	public ImageFourthCategory createImage(@Valid ImageFourthCategory imageFourthCatgeory);

	public List<ImageFourthCategory> getAllFourthCategoryImage();

	public ImageFourthCategory getAllFourthCategoryImageById(Integer imageFourthId) throws GlobalException;

	public ImageFourthCategory updateImageFourthCategory(Integer imageFourthId,
			ImageFourthCategory updatedImageFourthCategory) throws GlobalException;

	public void deleteImageFourthCategory(Integer imageFourthId) throws GlobalException;

	public ImageFourthCategory setFourthCategoryidToImageCategory(Integer imageFourthId, Integer fourthlevelcategoryId) throws GlobalException;

	

}
