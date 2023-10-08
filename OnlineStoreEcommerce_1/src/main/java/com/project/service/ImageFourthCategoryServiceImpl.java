package com.project.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dao.FourthLevelCategory;
import com.project.dao.ImageFourthCategory;
import com.project.error.GlobalException;
import com.project.repository.FourthLevelCategoryRepository;
import com.project.repository.ImageFourthCategoryRepository;

@Service
public class ImageFourthCategoryServiceImpl implements ImageFourthCategoryService {
	 @Autowired
     private FourthLevelCategoryRepository fourthLevelCategoryRepository;
     @Autowired
     private ImageFourthCategoryRepository imageFourthCategoryRepository;
	@Override
	public ImageFourthCategory createImage(@Valid ImageFourthCategory imageFourthCatgeory) {
	
		return imageFourthCategoryRepository.save(imageFourthCatgeory);
	}
	@Override
	public List<ImageFourthCategory> getAllFourthCategoryImage() {
		return imageFourthCategoryRepository.findAll();
	}
	@Override
	public ImageFourthCategory getAllFourthCategoryImageById(Integer imageFourthId) throws GlobalException {
	
		Optional<ImageFourthCategory> img=imageFourthCategoryRepository.findById(imageFourthId);
		ImageFourthCategory img1=null;
		if(!img.isPresent()) 
		{
			throw new GlobalException("Category with id "+ imageFourthId+" not found");
		}else {
			img1=imageFourthCategoryRepository.findById(imageFourthId).get();
			return img1;
		}
	}
	@Override
	public ImageFourthCategory updateImageFourthCategory(Integer imageFourthId,
			ImageFourthCategory updatedImageFourthCategory) throws GlobalException {
		 Optional<ImageFourthCategory> imageFourthCategoryOptional =imageFourthCategoryRepository.findById(imageFourthId);
		 if (!imageFourthCategoryOptional.isPresent())
	     {
			   throw new GlobalException("Image with id " + imageFourthId + " not found");
	     }
		    ImageFourthCategory existingImageFourthCategory = imageFourthCategoryOptional.get();
		    existingImageFourthCategory.setImageData(updatedImageFourthCategory. getImageData());
			    return imageFourthCategoryRepository.save(existingImageFourthCategory);
		 }
	@Override
	public void deleteImageFourthCategory(Integer imageFourthId) throws GlobalException {
		 Optional<ImageFourthCategory > imageFourthCategoryOptional = imageFourthCategoryRepository.findById(imageFourthId);
		 if (!imageFourthCategoryOptional.isPresent())
		 {
		       throw new GlobalException("Image with id " + imageFourthId + " not found");
		  }
		   imageFourthCategoryRepository.deleteById(imageFourthId);
		  }
	@Override
	public ImageFourthCategory setFourthCategoryidToImageCategory(Integer imageFourthId,
			Integer fourthlevelcategoryId) throws GlobalException {
		//image
		Optional<ImageFourthCategory> img = imageFourthCategoryRepository.findById(imageFourthId);
	    if (!img.isPresent()) {
	        throw new GlobalException("Image not exist " + imageFourthId);
	    }
//fourth
	    Optional<FourthLevelCategory> fourthCate =  fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
	    if (!fourthCate .isPresent()) {
	        throw new GlobalException("FourthLevelCategory not exist " + fourthlevelcategoryId);
	    }

	    ImageFourthCategory img1 = imageFourthCategoryRepository.findById(imageFourthId).get();
	    FourthLevelCategory  fourthCate1 = fourthLevelCategoryRepository.findById(fourthlevelcategoryId).get();

	    if (img1 != null) {
	        img1.setFourthLevelCategory(fourthCate1);
	    }

	    return imageFourthCategoryRepository.save(img1);
	}
	
	
	}
		

	


	

