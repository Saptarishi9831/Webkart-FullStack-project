package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dao.Category;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;

@Repository
public interface SubSubCategoryRepository extends JpaRepository<SubSubCategory, Integer> {


}
