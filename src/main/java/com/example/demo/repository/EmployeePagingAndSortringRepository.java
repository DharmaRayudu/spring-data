package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Employee;

public interface EmployeePagingAndSortringRepository extends PagingAndSortingRepository<Employee, Long>{

}
