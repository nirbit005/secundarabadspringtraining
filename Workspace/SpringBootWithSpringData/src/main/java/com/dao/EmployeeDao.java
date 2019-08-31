package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bean.Employee;


public interface EmployeeDao  extends JpaRepository<Employee, Integer>{
				
			@Query("select e from Employee e where e.salary > ?1")
			public List<Employee> getEmployeeBySalaries(float salary);
}
