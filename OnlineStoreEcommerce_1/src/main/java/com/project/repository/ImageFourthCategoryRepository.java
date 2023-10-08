package com.project.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dao.ImageFourthCategory;

@Repository
public interface ImageFourthCategoryRepository extends JpaRepository<ImageFourthCategory,Integer> 
{



}
