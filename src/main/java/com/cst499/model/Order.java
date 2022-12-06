package com.cst499.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	private String oId;
	
	// column names for field in the database table
	@Column(name = "cId")
	private String cId;
	
	@Column(name = "total")
	private String total;
	
	@Column(name = "paymentCard")
	private String paymentCard ;
	
	@Column(name = "street")
	private String street ;
	
	@Column(name = "city")
	private String city ;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private String zip ;
	
	public Order() {
		
	}

	public Order(String oId, String total, String paymentCard, String street, String city, String state, String zip, String cId) {
		super();
		this.oId = oId;
		this.total = total;
		this.paymentCard = paymentCard;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.cId = cId;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPaymentCard() {
		return paymentCard;
	}

	public void setPaymentCard(String paymentCard) {
		this.paymentCard = paymentCard;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
	
	

}
