package com.cst499.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cst499.model.CartItem;


public interface CartItemRepository  extends JpaRepository <CartItem, Long >{

	@Query("Select c From CartItem c WHERE c.cId =:cId")
	List<CartItem> searchcIdByQuery(String cId);
	

}
