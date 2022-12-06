package com.cst499.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cst499.model.CartItem;
import com.cst499.model.ProcessedCartItem;

public interface ProcessedCartItemRepository  extends JpaRepository <ProcessedCartItem, Long >{
	
	@Query("Select c From ProcessedCartItem c WHERE c.cId =:cId")
	List<ProcessedCartItem> searchcIdByQuery(String cId);
	
	@Query("Select c From ProcessedCartItem c WHERE c.oId =:oId")
	List<ProcessedCartItem> searchoIdByQuery(String oId);
	
	@Query("Select c From ProcessedCartItem c WHERE c.sId =:sId")
	List<ProcessedCartItem> searchsIdByQuery(String sId);
	
	@Query("Select c From ProcessedCartItem c WHERE c.ciId =:ciId")
	ProcessedCartItem searchCiIdByQuery(String ciId);
	
	
	@Query("Select c From ProcessedCartItem c WHERE c.ciId =:ciId")
	List<ProcessedCartItem> searchciIdByQuery(String ciId);

}
