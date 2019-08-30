package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

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

}
