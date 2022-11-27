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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cst499.exception.ResourceNotFoundException;
import com.cst499.model.Product;
import com.cst499.model.Consumer;
import com.cst499.model.Seller;
import com.cst499.repository.ConsumerRepository;
//
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //typical for rest apis


public class ConsumerController {
	
	/////?????????????????????????????????????????????///???????????????????????????????????????

	
	
	// inject product repo here
	@Autowired
	private ConsumerRepository consumerRepository;
	
	// get all products
	/// this rest api should return a list of all products 
	@GetMapping("/consumers")
	public List<Consumer> getAllConsumers(){
		return consumerRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/consumers")
	public Consumer createConsumer(@RequestBody Consumer consumer) {
		return consumerRepository.save(consumer);
	}
	
	// get seller by id rest api
		@GetMapping("/consumers/{consumerId}")
		public ResponseEntity<Consumer> getConsumertById(@PathVariable Long consumerId) {
			Consumer consumer = consumerRepository.findById(consumerId)
					.orElseThrow(() -> new ResourceNotFoundException("Consumer does not exist with this id :" + consumerId));
			return ResponseEntity.ok(consumer);
		}
	//	
//		// update seller rest api
	//	
		@PutMapping("/consumers/{consumerId}")
		public ResponseEntity<Consumer> updateConsumer(@PathVariable Long consumerId, @RequestBody Consumer consumerDetails){
			Consumer consumer = consumerRepository.findById(consumerId)
					.orElseThrow(() -> new ResourceNotFoundException("Consumer does not exist with id :" + consumerId));
			
			consumer.setConsumerId(consumerDetails.getConsumerId());
			//seller.setsLastName(sellerDetails.getsLastName());
			//seller.setEmail(sellerDetails.getEmail());
			//seller.setProducts(sellerDetails.getProducts());
			//seller.setsFirstName(sellerDetails.getsFirstName());
			consumer.setPassword(consumerDetails.getPassword());
			consumer.setcId(consumerDetails.getcId());

			
			
			Consumer updatedConsumer = consumerRepository.save(consumer);
			return ResponseEntity.ok(updatedConsumer);
		}
	//	
//		// delete seller rest api
		@DeleteMapping("/consumers/{consumerId}")
		public ResponseEntity<Map<String, Boolean>> deleteConsumer(@PathVariable Long consumerId){
			Consumer consumer = consumerRepository.findById(consumerId)
					.orElseThrow(() -> new ResourceNotFoundException("Consumer does not exist with this id :" + consumerId));
			
			consumerRepository.delete(consumer);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
//		//update seller by sid
		@GetMapping("/consumers/searchcId")
		public ResponseEntity<Consumer> searchConsumersId(@RequestParam("query") String query){
			Consumer consumer = consumerRepository.searchcIdByQuery(query);
			return ResponseEntity.ok(consumer);
		}
}	