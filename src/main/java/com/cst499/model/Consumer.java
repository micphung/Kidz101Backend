package com.cst499.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumers")

public class Consumer {

	

	// define primary key for table 
	@Id
//	@Column(nullable = false ,unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long consumerId;
	
	@Column(name = "cId")// nullable = false ,unique=true)
	private String cId;
    
	@Column(name = "password")
	private String password;
	

	// default constructor needed bc of hibernate creating prxys 
	public Consumer(){
		
		}


	public Consumer(long consumerId, String cId, String password) {
		super();
		this.consumerId = consumerId;
		this.cId = cId;
		this.password = password;
	}


	public long getConsumerId() {
		return consumerId;
	}


	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}


	public String getcId() {
		return cId;
	}


	public void setcId(String cId) {
		this.cId = cId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
