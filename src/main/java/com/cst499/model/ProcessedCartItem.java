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
@Table(name = "processedCartItems")
public class ProcessedCartItem {
	// define primary key for table 
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long pciId;
			
			// column names for field in the database table
			@Column(name = "cId")
			private String cId;
			
			@Column(name = "sId")
			private String sId ;
			
			@Column(name = "pId")
			private String pId ;
			
			@Column(name = "piName")
			private String piName ;
			
			@Column(name = "piUrl")
			private String piUrl ;
			
			@Column(name = "piPrice")
			private int piPrice ;
			
			@Column(name = "pQty")
			private int pQty;
			
			@Column(name = "oId")
			private String oId ;
			
			@Column(name = "ciId")
			private String ciId ;
			
			
			public ProcessedCartItem() {
				
			}


			public ProcessedCartItem(long pciId, String cId, String sId, String pId, String piName, String piUrl,
					int piPrice, int pQty, String oId, String ciId) {
				super();
				this.pciId = pciId;
				this.cId = cId;
				this.sId = sId;
				this.pId = pId;
				this.piName = piName;
				this.piUrl = piUrl;
				this.piPrice = piPrice;
				this.pQty = pQty;
				this.oId = oId;
				this.ciId = ciId;

			}


			public String getCiId() {
				return ciId;
			}


			public void setCiId(String ciId) {
				this.ciId = ciId;
			}


			public long getPciId() {
				return pciId;
			}


			public void setPciId(long pciId) {
				this.pciId = pciId;
			}


			public String getcId() {
				return cId;
			}


			public void setcId(String cId) {
				this.cId = cId;
			}


			public String getsId() {
				return sId;
			}


			public void setsId(String sId) {
				this.sId = sId;
			}


			public String getpId() {
				return pId;
			}


			public void setpId(String pId) {
				this.pId = pId;
			}


			public String getPiName() {
				return piName;
			}


			public void setPiName(String piName) {
				this.piName = piName;
			}


			public String getPiUrl() {
				return piUrl;
			}


			public void setPiUrl(String piUrl) {
				this.piUrl = piUrl;
			}


			public int getPiPrice() {
				return piPrice;
			}


			public void setPiPrice(int piPrice) {
				this.piPrice = piPrice;
			}


			public int getpQty() {
				return pQty;
			}


			public void setpQty(int pQty) {
				this.pQty = pQty;
			}


			public String getoId() {
				return oId;
			}


			public void setoId(String oId) {
				this.oId = oId;
			}
			

}
