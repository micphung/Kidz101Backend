package com.cst499.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;






// map the model to the database
@Entity
@Table(name = "sellers")

public class Seller {
	
	

		// define primary key for table 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long sellerId;
		
//		@OneToMany(cascade=CascadeType.ALL, mappedBy="seller")
//		private List<Product> products;
		
//		
		// column names for field in the database table
		@Column(name = "s_first_name")
		private String sFirstName;
		
		@Column(name = "s_last_name")
		private String sLastName;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "password")
		private String password;
		

		// default constructor needed bc of hibernate creating prxys 
		public Seller(){
			
		}

//List<Product> products, isert if needed
		public Seller(long sellerId, String sFirstName, String sLastName, String email,
				String password) {
			super();
			this.sellerId = sellerId;
			this.sFirstName = sFirstName;
			this.sLastName = sLastName;
			this.email = email;
			this.password = password;
		}


		public long getSellerId() {
			return sellerId;
		}


		public void setSellerId(long sellerId) {
			this.sellerId = sellerId;
		}


//		public List<Product> getProducts() {
//			return products;
//		}
//
//
//		public void setProducts(List<Product> products) {
//			this.products = products;
//		}


		public String getsFirstName() {
			return sFirstName;
		}


		public void setsFirstName(String sFirstName) {
			this.sFirstName = sFirstName;
		}


		public String getsLastName() {
			return sLastName;
		}


		public void setsLastName(String sLastName) {
			this.sLastName = sLastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
		
		