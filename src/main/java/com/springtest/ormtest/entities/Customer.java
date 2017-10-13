package com.springtest.ormtest.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String address;

// OneToMany and ManyToOne relationship mapping
	@OneToMany(mappedBy="owner")	// "owner" is the property from the other side.
									// indicating it's the same relationship
	private Set<Account> accounts;	// can add OrderBy("created_on ASC") to replace List with Set

// ManyToMany relationship
	@ManyToMany
	@JoinTable(
		name="customers_products",
		joinColumns=@JoinColumn(name="customer_id"),	// new column name to ref ID in this table
		inverseJoinColumns=@JoinColumn(name="product_id")	// new column name to ref ID of the other table
	)
	private Set<Products> boughtProducts;	// bought

	@ElementCollection
	@CollectionTable(name="CustomerGroupJoin", joinColumns={@JoinColumn(name="customerId")})
	private Set<GroupedCustomer> customerGroups = new HashSet<>();

	public Customer(String name) {
		this.name = name;
	}

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Products> getBoughtProducts() {
		return boughtProducts;
	}

	public void setBoughtProducts(Set<Products> boughtProducts) {
		this.boughtProducts = boughtProducts;
	}

	public Set<GroupedCustomer> getCustomerGroups() {
		return customerGroups;
	}

	public void setCustomerGroups(Set<GroupedCustomer> customerGroups) {
		this.customerGroups = customerGroups;
	}

	public void addGroup(GroupedCustomer gc) {
		this.customerGroups.add(gc);
	}
}
