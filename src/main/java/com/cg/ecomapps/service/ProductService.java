package com.cg.ecomapps.service;

import java.util.List;

import com.cg.ecomapps.entity.Product;


public interface ProductService {
	
	Product saveProduct(Product product);
	
	Product findProductById(int productId);
	
	List<Product> getAllProducts();
	
	void deleteProduct(int productId);
	
	Product updateProduct(Product product);
	
	Product findProductDetailsByName(String productName);
	
	List<Product> findProductDetailsByCategory
	(String productCategory);
	
	List<Product> getProductsUnderPrice(double productPrice);
	
	List<Product> getProductsInRange(double lowerPrice,double upperPrice);
}

