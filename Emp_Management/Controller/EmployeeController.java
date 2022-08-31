package com.example.Controller;

import java.awt.print.Pageable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.*;
import com.example.service.EmployeeService;
import java.util.List;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
//	
//	//with out paging
	@GetMapping("/Employees")
	public List<Employee> getALLEmployees(){
	return employeeService.getAllEmployees();
	}
	
	
//	//with paging
//	@GetMapping("/Employees")
//	public Page<Employee> getALLEmployees(Pageable page){
//		return employeeService.getAllEmployees(page);
//	}
	
	@GetMapping("/Employees/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@DeleteMapping("Employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
	
	@PostMapping("Employees/createEmployee")
	public Employee createNewEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
	@PutMapping("Employees/editEmployee/{id}")
	public Employee editEmployee(@RequestBody Employee emp,@PathVariable int id) {
		return employeeService.editEmployee(emp,id);
	}
	
}	
