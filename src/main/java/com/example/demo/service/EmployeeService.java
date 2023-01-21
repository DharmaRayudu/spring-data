package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees(Integer pageNumber, Integer pageSize);
	
	public Employee saveEmployee(Employee emp);
	
	public Employee getEmployeeById(Long id);
	
	public void deleteById(Long id);
	
	public Employee updateRecord(Employee emp);
	
	public List<Employee> findByName(String name);
	
	public List<Employee> findByNameAndLocation(String name, String location);
	
	public List<Employee> findByKeyword(String name);
}
