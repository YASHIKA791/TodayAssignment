package com.example.demoYashika.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoYashika.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//save()  find() findAll()
}
