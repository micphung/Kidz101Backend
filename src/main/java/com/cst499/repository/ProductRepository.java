package com.cst499.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cst499.model.Product;

// jparep exposes database screen methods like find by id and delete by id
// param are entity and PK type 


@Repository 
public interface ProductRepository extends JpaRepository <Product, Long > {

	
	//@Query("select p from Product p where p.seller.sellerId=:sellerId")
	//@Query("select p from Product p where p.seller.sellerId= ?1")
//	@Query("select p from Product p where p.sId = ?1")
//    public List<Product> findProductBySellerId(long sId);
//	 public List<Product> findProductBySellerId(long sellerId);
	
//	@Query("select p from Product p where p.sId=:sId")
//    public List<Product> findProductBySellerId(@Param("sId") long sId);
	
	
	
	// use for filtering keywords
//	@Query("Select p From Product p WHERE p.pName LIKE CONCAT('%. :query,'%') OR p.sId LIKE CONCAT ('%. :query,'%')")
	
	@Query("Select p From Product p WHERE p.sId =:sId")
	List<Product> searchsIdByQuery(String sId);
	
	@Query("Select p From Product p WHERE p.pName LIKE CONCAT('%',:query,'%') OR p.pName LIKE CONCAT('%',:query,'%')"+
	"OR p.department LIKE CONCAT('%',:query,'%')")
	List<Product> searchByQuery(String query);
	
}
