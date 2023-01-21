package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
 List<Employee>	 findByName(String name);
 
 List<Employee> findByNameAndLocation(String name, String location);
 
 List<Employee> findByNameContaining(String name, Sort sort);
 
 @Query("FROM Employee WHERE name = :name OR location = :location")
 List<Employee> findByNameOrLocation(String name, String location);
 
 @Query("From Employee")
 List<Employee> getAll();
 
 @Transactional
 @Modifying //When we write delete, update, create queries we should use @Modifing annotation , else it throws exception
 @Query("DELETE FROM Employee WHERE name = :name")
Integer deleteEmployeeByName(String name);
 
}
