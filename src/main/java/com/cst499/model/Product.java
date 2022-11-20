package com.cst499.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// map the model to the database
@Entity
@Table(name = "products")

public class Product {
	
	// define primary key for table 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// column names for field in the database table
	@Column(name = "p_name")
	private String pName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "sId")
	private String sId;
	
	
	// default constructor needed bc of hibernate creating prxys 
	public Product(){
		
	}
	
	
	
	public Product(String pName, String department, String imageUrl, int price, int quantity, String sId) {
		super();
		this.pName = pName;
		this.department = department;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
		this.sId= sId;
	}
	public long  getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getsId() {
		return sId;
	}



	public void setsId(String sId) {
		this.sId = sId;
	} 

}