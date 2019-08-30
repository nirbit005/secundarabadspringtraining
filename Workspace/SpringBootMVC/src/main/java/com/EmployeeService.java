package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	public List<Employee> getEmployeeDetails() {
		return employeeDao.getEmployeeDetails();
	}
}
