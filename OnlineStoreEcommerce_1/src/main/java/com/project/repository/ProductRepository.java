package com.project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dao.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer>{

	 @Query("SELECT p FROM Product p WHERE " +
	            "p.productName LIKE CONCAT('%', :query, '%')" +
	            "OR p.productBrand LIKE CONCAT('%', :query, '%')" +
	            "OR p.productDescription LIKE CONCAT('%', :query, '%')")
	    List<Product> searchProducts(String query);


	

}
