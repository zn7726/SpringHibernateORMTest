package com.springtest.ormtest.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	// default(if not defined) no cascade operations will be triggered 
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE}) // do not delete supervisor
	private Employee supervisor;
	
	// columns in Address table will be added/embedded in Employee table
	@Embedded
	private Address address;
	
// mapping collection of simple type //////////////////
	@ElementCollection	// only this annotation is mandatory
	@CollectionTable(	// following 2 annotations are for customization only
			name="employee_phones",
			joinColumns=@JoinColumn(name="customer_id"))
	@Column(name="phone")
	private Set<String> phones;	// objects in a Set is unordered, similar to records in a table
	
	@ElementCollection	
	@CollectionTable(	
			name="employee_phones_ordered",
			joinColumns=@JoinColumn(name="customer_id"))
	@OrderColumn(name="phone_order")
	@Column(name="phone")
	private List<String> orderedPhones;	// objects in a List is ordered, 
										// need to use either @OrderBy or an extra column @OrderColumn
	
	
// mapping collection of Object type //////////////////	
	
	public Employee()  {	}

	public int getId() {
		return id;
	}

	public Employee setId(final int value) {
		id = value;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(final String value) {
		name = value;
		return this;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public Employee setSupervisor(Employee value) {
		supervisor = value;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public List<String> getOrderedPhones() {
		return orderedPhones;
	}

	public void setOrderedPhones(List<String> orderedPhones) {
		this.orderedPhones = orderedPhones;
	}
	
	
}
