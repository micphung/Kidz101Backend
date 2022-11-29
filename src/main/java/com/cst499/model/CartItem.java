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






//map the model to the database
@Entity
@Table(name = "cartItems")
public class CartItem {

	// define primary key for table 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long ciId;
		
		// column names for field in the database table
		@Column(name = "cId")
		private String cId;
		
		@Column(name = "iName")
		private String iName ;
		
		@Column(name = "iUrl")
		private String iUrl ;
		
		@Column(name = "iPrice")
		private int iPrice ;
		
		@Column(name = "qty")
		private int qty;
		
		public CartItem() {
			
		}

		public CartItem(long ciId, String cId, String iName, String iUrl, int iPrice, int qty) {
			super();
			this.ciId = ciId;
			this.cId = cId;
			this.iName = iName;
			this.iUrl = iUrl;
			this.iPrice = iPrice;
			this.qty = qty;
		}

		public long getCiId() {
			return ciId;
		}

		public void setCiId(long ciId) {
			this.ciId = ciId;
		}

		public String getcId() {
			return cId;
		}

		public void setcId(String cId) {
			this.cId = cId;
		}

		public String getiName() {
			return iName;
		}

		public void setiName(String iName) {
			this.iName = iName;
		}

		public String getiUrl() {
			return iUrl;
		}

		public void setiUrl(String iUrl) {
			this.iUrl = iUrl;
		}

		public int getiPrice() {
			return iPrice;
		}

		public void setiPrice(int iPrice) {
			this.iPrice = iPrice;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}
		
		
		
		
}
