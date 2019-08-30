package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	public String storeEmployeeInfo(Employee emp) {
					if(emp.getSalary()>12000) {
							if(employeeDao.storeEmployeeInfo(emp)>0) {
								return "Record stored";
							}else {
								return "Record not store";
							}
					}else {
						return "Salary must be > 12000";
					}
	}
}
