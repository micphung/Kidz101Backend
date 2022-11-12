package com.cst499.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst499.model.Product;

// jparep exposes database screen methods like find by id and delete by id
// param are entity and PK type 


@Repository 
public interface ProductRepository extends JpaRepository <Product, Long > {

}
