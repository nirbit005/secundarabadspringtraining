package com.service;

import java.util.List;
import java.util.ListIterator;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.bean.TrainerStudent;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	// Below code is without JPA
/*	
	  public Employee getEmployeeInfo(int id) {
		return employeeDao.getEmployeeInfo(id);
	}
	  
	  public String storeEmployeeInfo(Employee emp) {
		  
		  if(employeeDao.storeEmployeeInfo(emp) > 0) {
			  return "Record Strored Successfully";
		  }else {
			  return "Record Not Strored"; 
		  }
		  
	  }
	  
	  public String updateEmployeeInfo(Employee emp) {
		  
		  if(employeeDao.updateEmployeeInfo(emp) > 0) {
			  return "Record Updated Successfully";
		  }else {
			  return "Record Not Updated"; 
		  }
		  
	  }
	  
	  public String deleteEmployeeInfo(int id) {
		  
		  if(employeeDao.deleteEmployeeInfo(id) > 0) {
			  return "Record Deleted Successfully";
		  }else {
			  return "Record Not Deleted"; 
		  }
		  
	  }
	  
	  */
	
	// Below part is with JPA
	
	public List<Employee> getEmployeeInfo(){
		
		List<Employee> listOfRec = employeeDao.getEmployeeInfo();
		ListIterator<Employee> ll = listOfRec.listIterator();
		while(ll.hasNext()) {
			Employee emp = ll.next();
			emp.setSalary(emp.getSalary()+10000);
		}
		
		return listOfRec;
		
	}
	
	public List<TrainerStudent> getTrainerStudent(){
		return employeeDao.getTrainerStudentInfo();
	}
	
	//If Transactional annotation added in service layer then 
	//   comment the begin and commit part on DAO layer which was used for maintaining transaction.
//	@Transactional()   ---->AT Present not working so commented and begin and comiit restored.
	
	
	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor  = Exception.class, timeout = 5)
//	@Transactional
	public String storeEmployeeInfo(Employee emp) {
		try {
			Thread.sleep(2000);
			employeeDao.storeEmployeeInfo(emp);	
			String msg="";
			System.out.println("Emp Id is - "+ emp.getId());
			if(employeeDao.deleteStudentInfoById(emp.getId()) > 0)
				msg="Deletion Success";
			else {
				msg="Deletion failed";
				throw new java.lang.Exception();
			}
			System.out.println(msg);
			return msg;
		//	return employeeDao.storeEmployeeInfo(emp);
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return "Data Store Service Failed";
	}
}
