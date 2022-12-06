package com.cst499.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cst499.model.Order;


public interface OrderRepository extends JpaRepository <Order, String >{
	
	@Query("Select c From Order c WHERE c.cId =:cId")
	List<Order> searchcIdByQuery(String cId);
	
	@Query("Select c From Order c WHERE c.oId =:oId")
	Order searchoIdByQuery(String oId);
	
//	@Query("Select c From Order c WHERE c.ciId =:ciId")
//	Order searchCiIdByQuery(String ciId);
	

}
