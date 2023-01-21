package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Value("${app.name}")
	private String appName;

	@Value("${app.version}")
	private String version;

	@GetMapping("/appDetails")
	public String getAppDetails() {
		return appName + "  " + version;
	}

	@GetMapping(value = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
		return new ResponseEntity<List<Employee>>(empService.getAllEmployees(pageNo, pageSize), HttpStatus.OK);
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmploye(@PathVariable("id") Long id) {

		return new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee>  savingEmployee(@Valid @RequestBody Employee emp) {
		return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		emp.setId(id);
		return new ResponseEntity<Employee>(empService.updateRecord(emp), HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
		empService.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/employees/name/{name}")
	public ResponseEntity<List<Employee>> findByName(@PathVariable String name){
		return new ResponseEntity<List<Employee>>( empService.findByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/employees/data/{name}/{location}")
	public ResponseEntity<List<Employee>> findByNameAndLocation(@PathVariable String name, @PathVariable String location){
		return new ResponseEntity<List<Employee>>(empService.findByNameAndLocation(name, location), HttpStatus.OK);
	}
	
	@GetMapping("/employees/names/{name}")
	public ResponseEntity<List<Employee>> findByNameContaining(@PathVariable String name){
		return new ResponseEntity(empService.findByKeyword(name), HttpStatus.OK);
	}
	

}
