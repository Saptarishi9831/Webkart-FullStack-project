package com.project.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.Category;
import com.project.dao.FourthLevelCategory;
import com.project.dao.Product;
import com.project.dao.SubCategory;
import com.project.dao.SubSubCategory;
import com.project.error.GlobalException;
import com.project.service.ProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@Valid @RequestBody Product product) {
       Product addProductedCategory = productService.addProduct(product);
        if (addProductedCategory  != null) 
        {
            return new ResponseEntity<>("Product Added Successfully", HttpStatus.CREATED);
        } 
        else 
        {
            return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
     }
    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> product = productService.getAllProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) throws GlobalException {
    	Product product = productService.getProductById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            throw new GlobalException("Product with ID " + productId + " not found");
        }
    }
    
    @PutMapping("/updateProduct/{productId}/{fourthlevelcategoryId}/{categoryid}/{subcategoryId}/{subSubCategoryId}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer productId,@PathVariable Integer fourthlevelcategoryId,@PathVariable Integer categoryid, @PathVariable Integer subcategoryId, @PathVariable Integer subSubCategoryId, @RequestBody Product updatedProduct) throws GlobalException {
        Product product= productService.updateProduct(productId,fourthlevelcategoryId, categoryid,subcategoryId,subSubCategoryId, updatedProduct);
        if (product != null) {
            return new ResponseEntity<>("Product Updated Successfully", HttpStatus.OK);
        } else {
            throw new GlobalException("Product with ID " + productId + " not found");
        }
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) throws GlobalException {
    	productService.deleteProduct(productId);
        return new ResponseEntity<>("Product with ID " + productId + " deleted successfully", HttpStatus.OK);
    }
    
    //categoryid
    @PutMapping("/setCategoryidToProduct{productId}/{categoryid}")
	  public Product setCategoryidToProduct(@PathVariable("productId") Integer productId,@PathVariable("categoryid") Integer categoryid) throws GlobalException 
	  {
		return productService.setCategoryidToProduct(productId,categoryid);
		  
	  }
    //subcate
    @PutMapping("/setSubCategoryidToProduct{productId}/{subcategoryid}")
	  public Product setSubCategoryidToProduct(@PathVariable("productId") Integer productId,@PathVariable("subcategoryid") Integer subcategoryid) throws GlobalException 
	  {
		return productService.setSubCategoryidToProduct(productId,subcategoryid);
		  
	  }
    //subsub
    
    @PutMapping("/setSubSubCategoryidToProduct{productId}/{subSubCategoryId}")
	  public Product setSubSubCategoryidToProduct(@PathVariable("productId") Integer productId,@PathVariable("subSubCategoryId") Integer subSubCategoryId) throws GlobalException 
	  {
		return productService.setSubSubCategoryidToProduct(productId,subSubCategoryId);
		  
	  }
    //fourth
    @PutMapping("/setFourthLevelCategoryidToProduct{productId}/{fourthlevelcategoryId}")
	  public Product setFourthLevelCategoryidToProduct(@PathVariable("productId") Integer productId,@PathVariable("fourthlevelcategoryId") Integer fourthlevelcategoryId) throws GlobalException 
	  {
		return productService.setFourthLevelCategoryidToProduct(productId,fourthlevelcategoryId);
		  
	  }
    
    @PutMapping("/setUseridToProduct{productId}/{id}")
	  public Product setUseridToProduct(@PathVariable("productId") Integer productId,@PathVariable("id") Integer id) throws GlobalException 
	  {
		return productService.setUseridToProduct(productId,id);
		  
	  }
  
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
        List<Product> products = productService.searchProducts(query);
        return ResponseEntity.ok(products);
    }

}

