package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeePagingAndSortringRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Autowired
	private EmployeePagingAndSortringRepository ePagingAndSortRepo;

	@Override
	public List<Employee> getAllEmployees(Integer pageNumber, Integer pageSize) {
		//This will do pagination and sorting by DESC using id
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		return ePagingAndSortRepo.findAll(pageable).getContent();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return eRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = eRepository.findById(id);
		
		if(emp.isPresent()) {
			return emp.get();
		}
		throw new RuntimeException("The Employee Record not Found "+ id);
	}

	@Override
	public void deleteById(Long id) {
		eRepository.deleteById(id);
		
	}

	@Override
	public Employee updateRecord(Employee emp) {
		return eRepository.save(emp);
	}

	@Override
	public List<Employee> findByName(String name) {
		
		return  eRepository.findByName(name);
	}

	@Override
	public List<Employee> findByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> findByKeyword(String name) {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return eRepository.findByNameContaining(name, sort);
	}

}
