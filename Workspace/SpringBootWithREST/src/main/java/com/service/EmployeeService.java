package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bean.Employee;
import com.dao.EmployeeDao;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	public Employee getEmployeeInfo(int id) {
			return employeeDao.getEmployeeInfo(id);
	}
	
	public String storeEmployeeInfo(Employee emp) {
				if(employeeDao.storeEmployeeInfo(emp)>0) {
					return "Record stored successfully";
				}else {
					return "Record not store";
				}
	}
	
	public String updateEmployeeInfo(Employee emp) {
		if(employeeDao.updateEmployeeInfo(emp)>0) {
			return "Record updated successfully";
		}else {
			return "Record not preset";
		}
	}
	public String deleteEmployeeInfo(int id) {
		if(employeeDao.deleteEmployeeInfo(id) >0) {
			return "Record deleted successfully";
		}else {
			return "Record not preset";
		}
	}
}
