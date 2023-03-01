package com.example.demoYashika.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoYashika.exception.ResourceNotFoundException;
import com.example.demoYashika.model.Employee;

import com.example.demoYashika.service.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EnployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/show") // GET HTTP Method
	public String show() {
		return "dfqecdkxlksfhcdjmq";
	}

	@GetMapping("/list") // GET HTTP Method
	public List<Employee> employeeList() {
		return employeeRepository.findAll();
	}

	@GetMapping("/listone/{id}") // GET HTTP Method
	public ResponseEntity<Optional<Employee>> readEmployee(@PathVariable(value = "id") Integer emloyeeId)
			throws ResourceNotFoundException {
		Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(emloyeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee not found for id")));
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/update/{id}") // GET HTTP Method
	public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable(value = "id") Integer emloyeeId,
			@RequestBody Employee emp) throws ResourceNotFoundException {
		Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(emloyeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee not found for id")));
		employee.get().setFirstName(emp.getFirstName());
		employee.get().setLastName(emp.getLastName());
		employee.get().setEducation(emp.getEducation());
		employee.get().setAge(emp.getAge());
		employee.get().setSalary(emp.getSalary());
		employeeRepository.save(employee.get());
		return ResponseEntity.ok().body(employee);

	}

	@PostMapping("/add") // GET HTTP Method
	public Employee addEmployee(@RequestBody Employee emp) {
		return employeeRepository.save(emp);
	}

	@DeleteMapping("/delete/{id}")// GET HTTP Method //delete
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="id") Integer employeeId) throws ResourceNotFoundException
	{
		Optional<Employee> employee=Optional.ofNullable(employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found for the id "+employeeId)));
		employeeRepository.delete(employee.get());
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}