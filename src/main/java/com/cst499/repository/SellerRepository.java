package com.cst499.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst499.model.Seller;
//import org.springframework.data.jpa.repository.Query;



@Repository 
public interface SellerRepository extends JpaRepository <Seller, Long > {

//	@Query("SELECT s FROM Seller s WHERE s.sId = ?1")
//	public Seller findSellerBysId(String sId);
}

