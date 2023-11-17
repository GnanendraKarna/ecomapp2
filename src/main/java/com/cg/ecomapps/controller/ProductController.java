package com.cg.ecomapps.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecomapps.entity.Product;
import com.cg.ecomapps.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> addProduct( @Valid @RequestBody Product product) {
		Product p = productService.saveProduct(product);
		
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Product> fetchAllProducts(){
		List<Product> productList = productService.getAllProducts();
		return productList;
	}
	
	@GetMapping("/get/{id}")
	public Product fetchProductById(@PathVariable("id") int productId) {
		Product product = productService.findProductById(productId);
		return product;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int productId){
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Customer deleted with ID - "+productId,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product){
		Product updatedProduct = productService.updateProduct(product);
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	}
	
	@GetMapping("/byName/{name}")
	public Product fetchProductByName(@PathVariable("name")String productName){
		Product product = productService.findProductDetailsByName(productName);
		return product;
	}
	
	@GetMapping("/byCategory/{productCategory}")
	public List<Product> fetchProductsByCategory(@PathVariable("productCategory")String categoryName){
		List<Product> productList = productService.findProductDetailsByCategory(categoryName);
		return productList;
	}
	
	@GetMapping("/byPrice/{productPrice}")
	public List<Product> fetchAllProductsUnderPrice(@PathVariable("productPrice") double productPrice){
		List<Product> productList = productService.getProductsUnderPrice(productPrice);
		return productList;
	}
	
	@GetMapping("/inPriceRange/{lowerPrice}/{upperPrice}")
	public List<Product> fetchAllProductsWithPriceRange(@PathVariable("lowerPrice") double lowerPrice,@PathVariable("upperPrice") double upperPrice){
		List<Product> productList = productService.getProductsInRange(lowerPrice, upperPrice);
		return productList;
	}
}

