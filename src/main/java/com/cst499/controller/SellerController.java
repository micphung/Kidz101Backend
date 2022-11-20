package com.cst499.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst499.exception.ResourceNotFoundException;
import com.cst499.model.Product;
import com.cst499.model.Seller;
import com.cst499.repository.SellerRepository;
//
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //typical for rest apis


public class SellerController {
	
	/////?????????????????????????????????????????????///???????????????????????????????????????

	
	
	// inject product repo here
	@Autowired
	private SellerRepository sellerRepository;
	
	// get all products
	/// this rest api should return a list of all products 
	@GetMapping("/sellers")
	public List<Seller> getAllSellers(){
		return sellerRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/sellers")
	public Seller createSeller(@RequestBody Seller seller) {
		return sellerRepository.save(seller);
	}
	
	// get seller by id rest api
		@GetMapping("/sellers/{id}")
		public ResponseEntity<Seller> getSellertById(@PathVariable Long id) {
			Seller seller = sellerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Seller does not exist with this id :" + id));
			return ResponseEntity.ok(seller);
		}
	//	
//		// update seller rest api
	//	
		@PutMapping("/sellers/{sellerId}")
		public ResponseEntity<Seller> updateSeller(@PathVariable Long sellerId, @RequestBody Seller sellerDetails){
			Seller seller = sellerRepository.findById(sellerId)
					.orElseThrow(() -> new ResourceNotFoundException("Seller does not exist with id :" + sellerId));
			
			seller.setSellerId(sellerDetails.getSellerId());
			//seller.setsLastName(sellerDetails.getsLastName());
			//seller.setEmail(sellerDetails.getEmail());
			//seller.setProducts(sellerDetails.getProducts());
			//seller.setsFirstName(sellerDetails.getsFirstName());
			seller.setPassword(sellerDetails.getPassword());
			seller.setsId(sellerDetails.getsId());

			
			
			Seller updatedSeller = sellerRepository.save(seller);
			return ResponseEntity.ok(updatedSeller);
		}
	//	
//		// delete seller rest api
		@DeleteMapping("/sellers/{sellerId}")
		public ResponseEntity<Map<String, Boolean>> deleteSeller(@PathVariable Long sellerId){
			Seller seller = sellerRepository.findById(sellerId)
					.orElseThrow(() -> new ResourceNotFoundException("Product does not exist with this id :" + sellerId));
			
			sellerRepository.delete(seller);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}