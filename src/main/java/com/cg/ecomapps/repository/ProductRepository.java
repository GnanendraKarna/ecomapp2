package com.cg.ecomapps.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ecomapps.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Optional<Product> findByProductName(String productName);
	
	List<Product> findByProductCategory(String productCategory);
	
	@Query("select p from Product p where p.productPrice <= :pPrice")
	List<Product> findProductUnderPrice(@Param("pPrice") double productPrice);
	
	@Query("select p from Product p where p.productPrice between :plowerPrice and :pupperPrice")
	List<Product> getProductsWithinPriceRange(@Param("plowerPrice") double lowerPrice, @Param("pupperPrice")double upperPrice);
}
