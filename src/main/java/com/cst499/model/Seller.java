package com.cst499.model;


import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;






// map the model to the database
@Entity
@Table(name = "sellers")

public class Seller {
	
	

		// define primary key for table 
		@Id
//		@Column(nullable = false ,unique=true)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long sellerId;
		
//		@OneToMany(cascade=CascadeType.ALL, mappedBy="seller")
//		private List<Product> products;
		
//	    @OneToMany(mappedBy = "seller")
//	    @JsonIgnore
////	    @JsonBackReference
//	    List<Product> products;
////		
//		// column names for field in the database table
//		@Column(name = "s_first_name")
//		private String sFirstName;
//		
//		@Column(name = "s_last_name")
//		private String sLastName;
//		
//		@Column(name = "email")
//		private String email;
		
	    @Column(name = "sId")// nullable = false ,unique=true)
		private String sId;
	    
		@Column(name = "password")
		private String password;
		

		// default constructor needed bc of hibernate creating prxys 
		public Seller(){
			
  		}


		public Seller(long sellerId, List<Product> products, String sId, String password) {
			super();
			this.sellerId = sellerId;
			//this.products = products;
			this.sId = sId;
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


		public String getsId() {
			return sId;
		}


		public void setsId(String sId) {
			this.sId = sId;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}

}
		
		