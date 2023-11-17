package com.cg.ecomapps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecomapps.entity.Product;
import com.cg.ecomapps.exception.ResourceNotFoundException;
import com.cg.ecomapps.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) throws ResourceNotFoundException{
		Optional<Product> p = productRepository.findById(productId);
		if(p.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with ID - "+productId);
		}
		return p.get();
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public void deleteProduct(int productId) throws ResourceNotFoundException{
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with ID - "+productId);
		}
		Product product = optionalProduct.get();
		productRepository.delete(product);
	}

	@Override
	public Product updateProduct(Product product) throws ResourceNotFoundException{
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not forund with ID - "+product.getProductId());
		}
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public Product findProductDetailsByName(String productName) throws ResourceNotFoundException{
		Optional<Product> optionalProduct = productRepository.findByProductName(productName);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with name - "+productName);
		}
		return optionalProduct.get();
	}

	@Override
	public List<Product> findProductDetailsByCategory(String productCategory) {
		List<Product> productList = productRepository.findByProductCategory(productCategory);
		if(productList.size()==0) {
			throw new ResourceNotFoundException("Product not found in that category");
			
		}
		return productList;
	}

	@Override
	public List<Product> getProductsUnderPrice(double productPrice) {
		List<Product> productList = productRepository.findProductUnderPrice(productPrice);
		if(productList.size()==0) {
			throw new ResourceNotFoundException("Product not available in that range");
		}
		return productList;
	}

	@Override
	public List<Product> getProductsInRange(double lowerPrice, double upperPrice) {
		
		List<Product> productList = productRepository.getProductsWithinPriceRange(lowerPrice, upperPrice);
		if(productList.size()==0) {
			throw new ResourceNotFoundException("Resource Not Found in that range");
			
		}
		return productList;
	}
	
	
}
