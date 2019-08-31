package com.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

import com.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(value = "allEmployeeInfo",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	public List<Employee> getAllEmployeeInfo() {
		return employeeService.getEmployeeInfo();
	}

	@RequestMapping(value = "storeEmployeeInfo",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String storeEmployeeInfo(@RequestBody Employee emp) {
		System.out.println("In Rest Method "+emp.getName());
		return employeeService.storeEmployeeInfo(emp);
	}

	@RequestMapping(value = "getEmpSalary/{salary}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
public List<Employee> getEmployeeDetailsBySalary(@PathVariable("salary") float salary){
		return employeeService.getEmployeeBySalaryDetails(salary);
	}
}
