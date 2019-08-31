package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bean.Employee;
import com.dao.EmployeeDao;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getEmployeeInfo() {
		return employeeDao.findAll();
	}
	
	public String storeEmployeeInfo(Employee emp) {
						employeeDao.save(emp);
						
						if(employeeDao.existsById(emp.getId())) {
							return "Record stored successfully";
						}else {
							return "Record not save";
						}
	}
	
	public List<Employee> getEmployeeBySalaryDetails(float salary){
		return employeeDao.getEmployeeBySalaries(salary);
	}
}
