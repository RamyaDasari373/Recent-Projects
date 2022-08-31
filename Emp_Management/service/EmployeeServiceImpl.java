package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public Employee getEmployee(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		System.out.println("**********************************"+emp);
		if(emp.isEmpty()) {
			System.out.println("no records found with given id");
		}
		return emp.get();
	}
	 public void deleteEmployee(int id) {
		 employeeRepository.deleteById(id);
	 }
	 public Employee saveEmployee(Employee emp) {
		 return employeeRepository.save(emp);
	 }
	 
	 public Employee editEmployee(Employee emp ,int id) {
		 Employee existingEmployee = getEmployee(id);
		 existingEmployee.setFirstName(emp.getFirstName() != null ? emp.getFirstName() : existingEmployee.getFirstName());
		 existingEmployee.setLastName(emp.getLastName() != null ? emp.getLastName() : existingEmployee.getLastName());
		 existingEmployee.setPhone(emp.getPhone() != null ? emp.getPhone() : existingEmployee.getPhone());
		 existingEmployee.setPlace(emp.getPlace() != null ? emp.getPlace() : existingEmployee.getPlace());
		 existingEmployee.setDepartment(emp.getDepartment() != null ? emp.getDepartment() : existingEmployee.getDepartment());
		 return employeeRepository.save(existingEmployee);
	}



}
