package com.project.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.Category;
import com.project.dao.FourthLevelCategory;
import com.project.dao.Product;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.dao.Users;
import com.project.error.GlobalException;
import com.project.repository.CategoryRepository;
import com.project.repository.FourthLevelCategoryRepository;
import com.project.repository.ProductRepository;
import com.project.repository.SubCategoryRepository;
import com.project.repository.SubSubCategoryRepository;
import com.project.repository.UserRepository;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private SubSubCategoryRepository subSubCategoryRepository;
	
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FourthLevelCategoryRepository fourthLevelCategoryRepository;

	@Override
	public Product addProduct(@Valid Product product) {
		 product.setDateadded(new Timestamp(new Date().getTime()));
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer productId) throws GlobalException {
		Optional<Product> product=productRepository.findById(productId);
		Product product1=null;
		if(!product.isPresent()) 
		{
			throw new GlobalException("Product with id "+ productId+" not found");
		}else {
			product1=productRepository.findById(productId).get();
			return product1;
		}
	}
	

	@Override
	public void deleteProduct(Integer productId) throws GlobalException {
		{
			 Optional<Product> productOptional = productRepository.findById(productId);
			 if (!productOptional.isPresent())
			 {
			       throw new GlobalException("Product id " + productId + " not found");
			  }
			      productRepository.deleteById(productId);
			  }
		
	}

	@Override
	public Product setCategoryidToProduct(Integer productId, Integer categoryid) throws GlobalException {
		Optional<Product> sub = productRepository.findById(productId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("product does not exist " + productId);
	    }

	    Optional<Category> cate = categoryRepository.findById(categoryid);
	    if (!cate.isPresent()) {
	        throw new GlobalException("Category not exist " + categoryid);
	    }

	    Product sub1 = productRepository.findById(categoryid).get();
	    Category cate1 = categoryRepository.findById(categoryid).get();

    if (sub1 != null) {
	        sub1.setCategory(cate1);
	    }

	    return productRepository.save(sub1);
	}

	@Override
	public Product setSubCategoryidToProduct(Integer productId, Integer subcategoryid) throws GlobalException {
		Optional<Product> sub = productRepository.findById(productId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("product does not exist " + productId);
	    }

	    Optional<SubCategory> cate = subCategoryRepository.findById(subcategoryid);
	    if (!cate.isPresent()) {
	        throw new GlobalException("SubCategory not exist " + subcategoryid);
	    }

	    Product sub1 = productRepository.findById(productId).get();
	    SubCategory cate1 = subCategoryRepository.findById(subcategoryid).get();

    if (sub1 != null) {
	        sub1.setSubcategory(cate1);
	    }

	    return productRepository.save(sub1);
	}

	@Override
	public Product setSubSubCategoryidToProduct(Integer productId, Integer subSubCategoryId) throws GlobalException {
		Optional<Product> sub = productRepository.findById(productId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("product does not exist " + productId);
	    }

	    Optional<SubSubCategory> cate = subSubCategoryRepository.findById(subSubCategoryId);
	    if (!cate.isPresent()) {
	        throw new GlobalException("SubSubCategory not exist " + subSubCategoryId);
	    }

	    Product sub1 = productRepository.findById(productId).get();
	    SubSubCategory cate1 = subSubCategoryRepository.findById(subSubCategoryId).get();

    if (sub1 != null) {
	        sub1.setSubSubcategory(cate1);
	    }

	    return productRepository.save(sub1);
	}

	@Override
	public Product setFourthLevelCategoryidToProduct(Integer productId, Integer fourthlevelcategoryId) throws GlobalException {
		Optional<Product> sub = productRepository.findById(productId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("product does not exist " + productId);
	    }

	    Optional<FourthLevelCategory> cate = fourthLevelCategoryRepository.findById(fourthlevelcategoryId);
	    if (!cate.isPresent()) {
	        throw new GlobalException("FourthLevelCategory not exist " + fourthlevelcategoryId);
	    }

	    Product sub1 = productRepository.findById(productId).get();
	    FourthLevelCategory cate1 = fourthLevelCategoryRepository.findById(fourthlevelcategoryId).get();

    if (sub1 != null) {
	        sub1.setFourthLevelCategory(cate1);
	    }

	    return productRepository.save(sub1);
	}

	@Override
		 public List<Product> searchProducts(String query) {
		        List<Product> products = productRepository.searchProducts(query);
		        return products;
	
	}

	@Override
	public Product setUseridToProduct(Integer productId, Integer id) throws GlobalException {
		Optional<Product> sub = productRepository.findById(productId);
	    if (!sub.isPresent()) {
	        throw new GlobalException("product does not exist " + productId);
	    }

	    Optional<Users> cate = userRepository.findById(id);
	    if (!cate.isPresent()) {
	        throw new GlobalException("User not exist " + id);
	    }

	    Product sub1 = productRepository.findById(productId).get();
	   Users cate1 = userRepository.findById(id).get();

    if (sub1 != null) {
	        sub1.setUsers(cate1);
	    }

	    return productRepository.save(sub1);
	}

	@Override
	public Product updateProduct(Integer productId, Integer fourthlevelcategoryId, Integer categoryid,
			Integer subcategoryId, Integer subSubCategoryId, Product updatedProduct) throws GlobalException {
		  Optional<Product> optionalProduct = productRepository.findById(productId);
	        if (optionalProduct.isPresent()) {
	            Product product = optionalProduct.get();

	            // Set FourthLevelCategory
	            FourthLevelCategory fourthLevelCategory = fourthLevelCategoryRepository.findById(fourthlevelcategoryId).orElse(null);
	            if (fourthLevelCategory == null) {
	                throw new GlobalException("FourthLevelCategory with id " + fourthlevelcategoryId + " not found");
	            }
	            product.setFourthLevelCategory(fourthLevelCategory);

	            // Set Category
	            Category category = categoryRepository.findById(categoryid).orElse(null);
	            if (category == null) {
	                throw new GlobalException("Category with id " + categoryid + " not found");
	            }
	            product.setCategory(category);

	            // Set SubCategory
	            SubCategory subCategory = subCategoryRepository.findById(subcategoryId).orElse(null);
	            if (subCategory == null) {
	                throw new GlobalException("SubCategory with id " + subcategoryId + " not found");
	            }
	            product.setSubcategory(subCategory);

	            // Set SubSubCategory
	            SubSubCategory subSubCategory = subSubCategoryRepository.findById(subSubCategoryId).orElse(null);
	            if (subSubCategory == null) {
	                throw new GlobalException("SubSubCategory with id " + subSubCategoryId + " not found");
	            }
	            product.setSubSubcategory(subSubCategory);

	            product.setProductName(updatedProduct.getProductName());
	            product.setProductPrice(updatedProduct.getProductPrice());
	            product.setProductSize(updatedProduct.getProductSize());
	            product.setProductBrand(updatedProduct.getProductBrand());
	            product.setProductDescription(updatedProduct.getProductDescription());
	            product.setProductQuantity(updatedProduct.getProductQuantity());
	            product.setProductImageUrls(updatedProduct.getProductImageUrls());
	            product.setInStock(updatedProduct.getInStock());
	            product.setDateadded(updatedProduct.getDateadded());
	            product.setUsers(updatedProduct.getUsers()); 

	            return productRepository.save(product);
	        } else {
	            throw new GlobalException("Product with id " + productId + " not found");
	        }
	}
	}
	

