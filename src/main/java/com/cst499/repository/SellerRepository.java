package com.cst499.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst499.model.Seller;



@Repository 
public interface SellerRepository extends JpaRepository <Seller, Long > {

}

