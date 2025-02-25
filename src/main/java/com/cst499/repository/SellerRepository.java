package com.cst499.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst499.model.Product;
import com.cst499.model.Seller;
//import org.springframework.data.jpa.repository.Query;



@Repository 
public interface SellerRepository extends JpaRepository <Seller, Long > {

//	@Query("SELECT s FROM Seller s WHERE s.sId = ?1")
//	public Seller findSellerBysId(String sId);
	
	@Query("Select s From Seller s WHERE s.sId =:query")
	Seller searchsIdByQuery(String query);
	
//	@Query("Select s From Seller s WHERE s.sId =:")
//	Seller searchPasswordByQuery(String query);
	
}

