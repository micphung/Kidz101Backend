package com.cst499.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cst499.model.Product;
import com.cst499.model.Seller;
import com.cst499.model.Consumer;
//import org.springframework.data.jpa.repository.Query;



@Repository 
public interface ConsumerRepository extends JpaRepository <Consumer, Long > {

//	@Query("SELECT s FROM Seller s WHERE s.sId = ?1")
//	public Seller findSellerBysId(String sId);
	
	@Query("Select c From Consumer c WHERE c.cId =:query")
	Consumer searchcIdByQuery(String query);
	
	
	@Query("Select c From Consumer c WHERE c.password =:password")
	Consumer searchcIdByPassword(String password);
	
	
	@Query("Select c From Consumer c WHERE c.cId =:cId AND  c.password =:password ")
	Consumer searchValidate(String cId, String password);
	
//	@Query("Select s From Seller s WHERE s.sId =:")
//	Seller searchPasswordByQuery(String query);
	
}
