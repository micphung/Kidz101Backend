package com.cst499.controller;

import java.util.ArrayList;
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
import com.cst499.model.ProcessedCartItem;
//import com.cst499.model.Seller;
import com.cst499.repository.ProcessedCartItemRepository;
//import com.cst499.repository.SellerRepository;
//
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //typical for rest apis


public class ProcessedCartItemController {
	

	@Autowired
	private ProcessedCartItemRepository processedCartItemRepository;

	
	
	// get all products
	/// this rest api should return a list of all products 
	@GetMapping("/processedCartItems")
	public List<ProcessedCartItem> getAllPItems(){
		return processedCartItemRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/processedCartItems")
	public ProcessedCartItem createItem(@RequestBody ProcessedCartItem processedCartItem) {
		return processedCartItemRepository.save(processedCartItem);
	}
//	

//	
//	// update employee rest api
//	
	@PutMapping("/processedCartItems/{pciId}")
	public ResponseEntity<ProcessedCartItem> updatePCartItem(@PathVariable Long pciId, @RequestBody ProcessedCartItem pCartItemDetails){
		ProcessedCartItem processedCartItem = processedCartItemRepository.findById(pciId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Item does not exist with id :" + pciId));
		
		processedCartItem.setPciId(pCartItemDetails.getPciId());
		processedCartItem.setcId(pCartItemDetails.getcId());
		processedCartItem.setsId(pCartItemDetails.getsId());
		processedCartItem.setoId(pCartItemDetails.getoId());
		processedCartItem.setpId(pCartItemDetails.getpId());
		processedCartItem.setPiName(pCartItemDetails.getPiName());
		processedCartItem.setPiPrice(pCartItemDetails.getPiPrice());
		processedCartItem.setPiUrl(pCartItemDetails.getPiUrl());
		processedCartItem.setpQty(pCartItemDetails.getpQty());
		processedCartItem.setCiId(pCartItemDetails.getCiId());

		
		
		ProcessedCartItem updatedPCartItem = processedCartItemRepository.save(processedCartItem);
		return ResponseEntity.ok(updatedPCartItem);
	}
//	
//	// delete employee rest api
	@DeleteMapping("/processedCartItems/{pciId}")
	public ResponseEntity<Map<String, Boolean>> deleteCartItem(@PathVariable Long pciId){
		ProcessedCartItem processedCartItem = processedCartItemRepository.findById(pciId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Item does not exist with this id :" + pciId));
		
		processedCartItemRepository.delete(processedCartItem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/processedCartItems/deleteCiId")
	public ResponseEntity<Map<String, Boolean>> deleteCartItemByCiId(@RequestParam("ciId") String ciId){
		//String ciId = Long.toString(_ciId);
		ProcessedCartItem processedCartItem = processedCartItemRepository.searchCiIdByQuery(ciId);
		
		processedCartItemRepository.delete(processedCartItem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/processedCartItems/searchCiId")
	public ResponseEntity<ProcessedCartItem> searchciIdItemsByQuery(@RequestParam("ciId") String ciId){
	ProcessedCartItem processedCartItem = processedCartItemRepository.searchCiIdByQuery(ciId);
	return ResponseEntity.ok(processedCartItem);
	}
	
	
	@GetMapping("/processedCartItems/searchcId")
	public ResponseEntity<List<ProcessedCartItem>> searchcIdItemsByQuery(@RequestParam("cId") String cId){
	List<ProcessedCartItem> processedCartItems = processedCartItemRepository.searchcIdByQuery(cId);
	return ResponseEntity.ok(processedCartItems);
	}
	
	@GetMapping("/processedCartItems/searchoId")
	public ResponseEntity<List<ProcessedCartItem>> searchoIdItemsByQuery(@RequestParam("oId") String oId){
	List<ProcessedCartItem> processedCartItems = processedCartItemRepository.searchoIdByQuery(oId);
	return ResponseEntity.ok(processedCartItems);
	}
	
	@GetMapping("/processedCartItems/Total")
	public int totalByoIdQuery(@RequestParam("oId") String oId){
	List<ProcessedCartItem> processedCartItems = processedCartItemRepository.searchoIdByQuery(oId);
	
	int total = 0;
	for(ProcessedCartItem c: processedCartItems) {
		System.out.println("The item price is " + c.getPiPrice());
		System.out.println("The item qty is " + c.getpQty());
		if(c.getpQty() > 0) {
			total = total + (c.getPiPrice() * c.getpQty());
		}else {
			System.out.println("Price " + c.getPiPrice());
			System.out.println("this is zero  " + c.getpQty());
		}
	}
	return total;
	}
	
	@GetMapping("/processedCartItems/listBysId")
	public ResponseEntity<List<ProcessedCartItem>> listItemsBysId(@RequestParam("sId") String sId){
		List<ProcessedCartItem> processedCartItems = processedCartItemRepository.searchsIdByQuery(sId);
		
	List<ProcessedCartItem> updatedProcessedCartItems = new ArrayList<>();
	for(ProcessedCartItem c: processedCartItems) {
		System.out.println("The item price is " + c.getPiPrice());
		System.out.println("The item qty is " + c.getpQty());
		if(c.getpQty() > 0) {
			updatedProcessedCartItems.add(c);
		}else {
			System.out.println("Price " + c.getPiPrice());
			System.out.println("this is zero  " + c.getpQty());
		}
	}
	return ResponseEntity.ok(updatedProcessedCartItems);}
	
	@GetMapping("/processedCartItems/listByoId")
	public ResponseEntity<List<ProcessedCartItem>> listItemsByoId(@RequestParam("oId") String oId){
		List<ProcessedCartItem> processedCartItems = processedCartItemRepository.searchoIdByQuery(oId);
		
	List<ProcessedCartItem> updatedProcessedCartItems = new ArrayList<>();
	for(ProcessedCartItem c: processedCartItems) {
		System.out.println("The item price is " + c.getPiPrice());
		System.out.println("The item qty is " + c.getpQty());
		if(c.getpQty() > 0) {
			updatedProcessedCartItems.add(c);
		}else {
			System.out.println("Price " + c.getPiPrice());
			System.out.println("this is zero  " + c.getpQty());
		}
	}
	return ResponseEntity.ok(updatedProcessedCartItems);
	}
	// did not use this 
//	@GetMapping("/cartItems/qtyTotal")
//	public int totalQtyByciIdQuery(@RequestParam("ciId") long ciId){
//		CartItem cartItem = cartItemRepository.findById(ciId)
//				.orElseThrow(() -> new ResourceNotFoundException("CartItem does not exist with this id :" + ciId));
//	
//	int qtyTotal = 0;
//	
//		System.out.println("The item price is " + cartItem.getiPrice());
//		System.out.println("The item qty is " + cartItem.getQty());
//		
//		
//		qtyTotal = qtyTotal + (cartItem.getiPrice() * cartItem.getQty());
//	return qtyTotal;
//	}
	
	
//	@GetMapping("/cartItems/search")
//	public ResponseEntity<List<CartItem>> searchProductsByQuery(@RequestParam("query") String query){
//	List<CartItem> products = cartItemRepository.searchByQuery(query);
//	return ResponseEntity.ok(products);
//	}
//	
//	@GetMapping("/processedCartItems/showByoId")
//	public ResponseEntity<ProcessedCartItem> getProcessedCartItemByoId(@RequestParam("oId") String oId) {
//		ProcessedCartItem processedCartItem = processedCartItemRepository.searchoIdByQueryUnit(oId);
//				
//		return ResponseEntity.ok(processedCartItem);
//	}
//	// get product by id rest api
	@GetMapping("/processedCartItems/{pciId}")
	public ResponseEntity<ProcessedCartItem> getCartItemById(@PathVariable Long pciId) {
		ProcessedCartItem processedCartItem = processedCartItemRepository.findById(pciId)
				.orElseThrow(() -> new ResourceNotFoundException("CartItem does not exist with this id :" + pciId));
		return ResponseEntity.ok(processedCartItem);
	}
	
	
	
//}
}
