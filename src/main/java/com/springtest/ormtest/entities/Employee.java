package com.springtest.ormtest.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToOne
	private Employee supervisor;

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

}
