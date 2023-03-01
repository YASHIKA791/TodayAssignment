package com.example.demoYashika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeNew")
public class Employee {
 @Id
 @GeneratedValue(strategy=GenerationType.SEQUENCE)
 @Column(name="Employee_Id")
 private int EmployeeId;
 @Column(name="firstName")
 private String firstName;
 @Column(name="lastName")
 private String lastName;
 @Column(name="age")
 private int age;
 
 @Column(name="salary")
 private double salary;
 @Column(name="education")
 private String education;
public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
 
 
}
