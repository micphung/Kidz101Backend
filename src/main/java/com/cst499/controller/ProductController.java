package com.cst499.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

import com.cst499.exception.ResourceNotFoundException;
import com.cst499.model.Product;
//import com.cst499.model.Seller;
import com.cst499.repository.ProductRepository;
//import com.cst499.repository.SellerRepository;
//
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //typical for rest apis


public class ProductController {
	
	// inject product repo here
	@Autowired
	private ProductRepository productRepository;
//	@Autowired
//	private SellerRepository SellerRepository;
	
//	@GetMapping(/products/{)
	
	
	// get all products
	/// this rest api should return a list of all products 
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
//	

//	
//	// update employee rest api
//	
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails){
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id :" + productId));
		
		product.setpName(productDetails.getpName());
		product.setDepartment(productDetails.getDepartment());
		product.setImageUrl(productDetails.getImageUrl());
		product.setPrice(productDetails.getPrice());
		product.setQuantity(productDetails.getQuantity());
		
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
//	
//	// delete employee rest api
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long productId){
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not exist with this id :" + productId));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

	
	@GetMapping("/products/searchsId")
	public ResponseEntity<List<Product>> searchsIdProductsByQuery(@RequestParam("sId") String sId){
	List<Product> products = productRepository.searchsIdByQuery(sId);
	return ResponseEntity.ok(products);
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProductsByQuery(@RequestParam("query") String query){
	List<Product> products = productRepository.searchByQuery(query);
	return ResponseEntity.ok(products);
	}
//	
//	// get product by id rest api
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not exist with this id :" + productId));
		return ResponseEntity.ok(product);
	}
	
//}
}