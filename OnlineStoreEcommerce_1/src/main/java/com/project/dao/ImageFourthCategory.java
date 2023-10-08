package com.project.dao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ImageFourthCategory {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer imageFourthId;
	 @Column(unique=true,length=500)
     private String imageData;
     
     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "fourth_level_category_id")
     private FourthLevelCategory fourthLevelCategory;

	public ImageFourthCategory() {
		super();
	}

	public ImageFourthCategory(String imageData, FourthLevelCategory fourthLevelCategory) {
		super();
		this.imageData = imageData;
		this.fourthLevelCategory = fourthLevelCategory;
	}

	public Integer getImageFourthId() {
		return imageFourthId;
	}

	public void setImageFourthId(Integer imageFourthId) {
		this.imageFourthId = imageFourthId;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public FourthLevelCategory getFourthLevelCategory() {
		return fourthLevelCategory;
	}

	public void setFourthLevelCategory(FourthLevelCategory fourthLevelCategory) {
		this.fourthLevelCategory = fourthLevelCategory;
	}

	@Override
	public String toString() {
		return "ImageFourthCategory [imageFourthId=" + imageFourthId + ", imageData=" + imageData
				+ ", fourthLevelCategory=" + fourthLevelCategory + "]";
	}
     
     
}