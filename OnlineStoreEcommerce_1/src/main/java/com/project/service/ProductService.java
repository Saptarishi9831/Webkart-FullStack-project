package com.project.service;

import java.util.List;

import javax.validation.Valid;

import com.project.dao.Category;
import com.project.dao.Product;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;

public interface ProductService {

	public Product addProduct(@Valid Product product);

	public List<Product> getAllProduct();

	public Product getProductById(Integer productId) throws GlobalException;

	public void deleteProduct(Integer productId) throws GlobalException;

	public Product setCategoryidToProduct(Integer productId, Integer categoryid) throws GlobalException;

	public Product setSubCategoryidToProduct(Integer productId, Integer subcategoryid) throws GlobalException;

	public Product setSubSubCategoryidToProduct(Integer productId, Integer subSubCategoryId) throws GlobalException;

	public Product setFourthLevelCategoryidToProduct(Integer productId, Integer fourthlevelcategoryId) throws GlobalException;

	public List<Product> searchProducts(String query);

	public Product setUseridToProduct(Integer productId, Integer id) throws GlobalException;

	public Product updateProduct(Integer productId, Integer fourthlevelcategoryId, Integer categoryid,
			Integer subcategoryId, Integer subSubCategoryId, Product updatedProduct) throws GlobalException;




}
