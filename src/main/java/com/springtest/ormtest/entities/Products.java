package com.springtest.ormtest.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	private Double price;
	
// ManyToMany
// in MtM mapping, it makes no difference on which side you define "mappedBy" because eventually a new
// association table will be created! 
// the generated name for the association table my be different depending on where the mappedBy is defined, however
// using the JoinTable annotation (have to be defined on the other side) to define the association table 
// will eliminate this difference
	@ManyToMany(mappedBy="boughtProducts")
	private Set<Customer> buyers;	// bought by

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Customer> getBuyers() {
		return buyers;
	}

	public void setBuyers(Set<Customer> buyers) {
		this.buyers = buyers;
	}
	
	
}
