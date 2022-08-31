package com.example.service;

import com.example.entity.*;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	 Employee getEmployee(int id);
	 void deleteEmployee(int id);
	 Employee saveEmployee(Employee emp);
	 Employee editEmployee(Employee emp,int id);
}
