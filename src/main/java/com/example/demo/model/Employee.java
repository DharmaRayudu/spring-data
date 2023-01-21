package com.example.demo.model;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employees")
public class Employee {

	//@JsonProperty("Full Name") This will bind Full Name with name property
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	@NotBlank(message = "Name should not be null")
	private String name;
	//@JsonIgnore This will hide the property.
	@Column(name="age")
	private Long age = 0l;
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	@Email(message = "Please enter correct email address!")
	private String email;
	
	@Column(name =  "department")
	@NotBlank(message = "Department should not be null")
	private String department;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false, updatable = false)
	private Date updatedAt;
}
