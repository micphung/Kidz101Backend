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
import com.cst499.model.CartItem;
//import com.cst499.model.Seller;
import com.cst499.repository.CartItemRepository;
//import com.cst499.repository.SellerRepository;
//
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //typical for rest apis


public class CartItemController {
	

	@Autowired
	private CartItemRepository cartItemRepository;

	
	
	// get all products
	/// this rest api should return a list of all products 
	@GetMapping("/cartItems")
	public List<CartItem> getAllItems(){
		return cartItemRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/cartItems")
	public CartItem createItem(@RequestBody CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
//	

//	
//	// update employee rest api
//	
	@PutMapping("/cartItems/{ciId}")
	public ResponseEntity<CartItem> updateCartItem(@PathVariable Long ciId, @RequestBody CartItem cartItemDetails){
		CartItem cartItem = cartItemRepository.findById(ciId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Item does not exist with id :" + ciId));
		
		cartItem.setCiId(cartItemDetails.getCiId());
		cartItem.setcId(cartItemDetails.getcId());
		cartItem.setiName(cartItemDetails.getiName());
		cartItem.setiUrl(cartItemDetails.getiUrl());
		cartItem.setiPrice(cartItemDetails.getiPrice());
		cartItem.setQty(cartItemDetails.getQty());

		
		
		CartItem updatedCartItem = cartItemRepository.save(cartItem);
		return ResponseEntity.ok(updatedCartItem);
	}
//	
//	// delete employee rest api
	@DeleteMapping("/cartItems/{ciId}")
	public ResponseEntity<Map<String, Boolean>> deleteCartItem(@PathVariable Long ciId){
		CartItem cartItem = cartItemRepository.findById(ciId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Item does not exist with this id :" + ciId));
		
		cartItemRepository.delete(cartItem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

	
	@GetMapping("/cartItems/searchcId")
	public ResponseEntity<List<CartItem>> searchcIdItemsByQuery(@RequestParam("cId") String cId){
	List<CartItem> cartItems = cartItemRepository.searchcIdByQuery(cId);
	return ResponseEntity.ok(cartItems);
	}
	
	@GetMapping("/cartItems/cartTotal")
	public int totalBycIdQuery(@RequestParam("cId") String cId){
	List<CartItem> cartItems = cartItemRepository.searchcIdByQuery(cId);
	
	int total = 0;
	for(CartItem c: cartItems) {
		System.out.println("The item price is " + c.getiPrice());
		System.out.println("The item qty is " + c.getQty());
		
		
		total = total + (c.getiPrice() * c.getQty());
	}
	
	return total;
	}
	// did not use this 
	@GetMapping("/cartItems/qtyTotal")
	public int totalQtyByciIdQuery(@RequestParam("ciId") long ciId){
		CartItem cartItem = cartItemRepository.findById(ciId)
				.orElseThrow(() -> new ResourceNotFoundException("CartItem does not exist with this id :" + ciId));
	
	int qtyTotal = 0;
	
		System.out.println("The item price is " + cartItem.getiPrice());
		System.out.println("The item qty is " + cartItem.getQty());
		
		
		qtyTotal = qtyTotal + (cartItem.getiPrice() * cartItem.getQty());
	return qtyTotal;
	}
	
	
//	@GetMapping("/cartItems/search")
//	public ResponseEntity<List<CartItem>> searchProductsByQuery(@RequestParam("query") String query){
//	List<CartItem> products = cartItemRepository.searchByQuery(query);
//	return ResponseEntity.ok(products);
//	}
//	
//	// get product by id rest api
	@GetMapping("/cartItems/{ciId}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable Long ciId) {
		CartItem cartItem = cartItemRepository.findById(ciId)
				.orElseThrow(() -> new ResourceNotFoundException("CartItem does not exist with this id :" + ciId));
		return ResponseEntity.ok(cartItem);
	}
	
	
	
//}
}
