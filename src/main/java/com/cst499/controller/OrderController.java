package com.cst499.controller;
import java.util.ArrayList;
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


import com.cst499.model.Order;
import com.cst499.repository.OrderRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") //typical for rest apis
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	
	
	// get all products
	/// this rest api should return a list of all products 
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
//	

//	
//	// update employee rest api
//	
	@PutMapping("/orders/{oId}")
	public ResponseEntity<Order> updateOrder(@PathVariable String oId, @RequestBody Order orderDetails){
		Order order = orderRepository.searchoIdByQuery(oId);
			
		
		order.setcId(orderDetails.getcId());
		order.setCity(orderDetails.getCity());
		order.setoId(orderDetails.getoId());
		order.setPaymentCard(orderDetails.getPaymentCard());
		order.setState(orderDetails.getState());
		order.setStreet(orderDetails.getStreet());
		order.setTotal(orderDetails.getTotal());
		order.setZip(orderDetails.getZip());
	

		
		
		Order updatedOrder = orderRepository.save(order);
		return ResponseEntity.ok(updatedOrder);
	}
//	
//	// delete employee rest api
	@DeleteMapping("/orders/{oId}")
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable String oId){
		Order order = orderRepository.searchoIdByQuery(oId);
		
		
		orderRepository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/orders/searchcId")
	public ResponseEntity<List<Order>> searchcIdOrdersByQuery(@RequestParam("cId") String cId){
	List<Order> order = orderRepository.searchcIdByQuery(cId);
	return ResponseEntity.ok(order);
	}
	
	@GetMapping("/orders/searchoId")
	public ResponseEntity <Order> searchOrderByOID(@RequestParam("oId") String oId){
	Order order = orderRepository.searchoIdByQuery(oId);
	return ResponseEntity.ok(order);
	}
	
	
//	@DeleteMapping("/orders/deleteoId")
//	public ResponseEntity<Map<String, Boolean>> deleteOrdeByOid(@RequestParam("ciId") String ciId){
//		//String ciId = Long.toString(_ciId);
//		Order processedCartItem = orderRepository.searchCiIdByQuery(ciId);
//		
//		orderRepository.delete(processedCartItem);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
//	@GetMapping("/orders/searchCiId")
//	public ResponseEntity<Order> searchciIdItemsByQuery(@RequestParam("ciId") String ciId){
//		Order processedCartItem = orderRepository.searchCiIdByQuery(ciId);
//	return ResponseEntity.ok(processedCartItem);
//	}
	

//	
//	@GetMapping("/orders/Total")
//	public int totalByoIdQuery(@RequestParam("oId") String oId){
//	List<Order> processedCartItems = orderRepository.searchoIdByQuery(oId);
//	
//	int total = 0;
//	for(Order c: processedCartItems) {
//		System.out.println("The item price is " + c.getPiPrice());
//		System.out.println("The item qty is " + c.getpQty());
//		if(c.getpQty() > 0) {
//			total = total + (c.getPiPrice() * c.getpQty());
//		}else {
//			System.out.println("Price " + c.getPiPrice());
//			System.out.println("this is zero  " + c.getpQty());
//		}
//	}
//	return total;
//	}
	
//	
//	@GetMapping("/orders/listByoId")
//	public ResponseEntity<List<Order>> listItemsByoId(@RequestParam("oId") String oId){
//		List<Order> processedCartItems = orderRepository.searchoIdByQuery(oId);
//		
//	List<Order> updatedProcessedCartItems = new ArrayList<>();
//	for(Order c: processedCartItems) {
//		System.out.println("The item price is " + c.getPiPrice());
//		System.out.println("The item qty is " + c.getpQty());
//		if(c.getpQty() > 0) {
//			updatedProcessedCartItems.add(c);
//		}else {
//			System.out.println("Price " + c.getPiPrice());
//			System.out.println("this is zero  " + c.getpQty());
//		}
//	}
//	return ResponseEntity.ok(updatedProcessedCartItems);
//	}
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
//	// get product by id rest api
//	@GetMapping("/orders/{pciId}")
//	public ResponseEntity<Order> getCartItemById(@PathVariable Long pciId) {
//		Order processedCartItem = orderRepository.findById(pciId)
//				.orElseThrow(() -> new ResourceNotFoundException("CartItem does not exist with this id :" + pciId));
//		return ResponseEntity.ok(processedCartItem);
//	}
//	
	
	

}
