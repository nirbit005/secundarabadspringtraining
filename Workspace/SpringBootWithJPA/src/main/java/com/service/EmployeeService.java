package com.service;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Employee;
import com.bean.TrainerStudent;
import com.main.EmployeeDao;
@Service

public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getEmployeeInfo() {
		List<Employee> listOfRec = employeeDao.getEmployeeInfo();
		ListIterator<Employee> ll = listOfRec.listIterator();
		while(ll.hasNext()) {
			Employee emp = ll.next();
			emp.setSalary(emp.getSalary()+10000);
		}
		return listOfRec;
	}
	
	public List<TrainerStudent> getTrainerStudent() {
		return employeeDao.getTrainerStudentInfo();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class,timeout = 5)
	public String storeEmployeeInfo(Employee emp) {
		try {
			Thread.sleep(2000);
			employeeDao.deleteStudentInfoById(emp.getId());
			return employeeDao.storeEmployeeInfo(emp);	
		}catch(Exception e) {}
		return null;
	}
	
	/*
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
	}*/
}

