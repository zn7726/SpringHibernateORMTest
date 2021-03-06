package com.springtest.ormtest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.ormtest.entities.Employee;
import com.springtest.ormtest.repos.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	List<Employee> getEmployeeById(@PathVariable Integer id){
		
		// return employeeRepo.findOne(id);
		
		return employeeRepo.findAll(new ArrayList<Integer>(){{
			add(id);
		}});
	}
	
	@RequestMapping(value="/byName", method=RequestMethod.GET)
	Employee getEmployeeByName(@RequestParam("name") String name){
		
		// return employeeRepo.findOne(id);
		
		return employeeRepo.findByName(name);
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	Employee updateEmployeeById(@PathVariable Integer id){
		
		// return employeeRepo.findOne(id);
		Employee emp = employeeRepo.findOne(id);
		emp.setName(emp.getName()+"_NEW");
		employeeRepo.save(emp);
		
		return employeeRepo.findOne(id);
	}
	
	@RequestMapping(value="/supervisor/{id}", method=RequestMethod.GET)
	public @ResponseBody String getEmployeeSupervisorById(@PathVariable Integer id){
		
		// return employeeRepo.findOne(id);
		Employee emp = employeeRepo.findOne(id);
				
		return "supervior name is: " + emp.getSupervisor().getName();
	}
	
	@RequestMapping(value="/build", method=RequestMethod.GET)
	public @ResponseBody String createEmpWithSupervisor(){
		
		// return employeeRepo.findOne(id);
		Employee emp = employeeRepo.findOne(1);
		
		Employee sup = new Employee();
		sup.setName("a supervisor");

		emp.setSupervisor(sup);
		
		employeeRepo.save(emp);
		
		return "supervior name is: (" + emp.getSupervisor().getId() + ") - " + emp.getSupervisor().getName();
	}
	

}
