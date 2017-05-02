package com.springtest.ormtest.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Double balance;
	
	@Column(name="created_on")
	private Date createdOn;

// OneToMany and ManyToOne relationship mapping
	@ManyToOne
	private Customer owner;	// <- bi-directional 
							// a pair of OneToMany defined in Customer class
							// owner_id column will always be added in Many side (this table)
							// Many side only holds a single reference (vs Set) to the ONE side 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	
}
