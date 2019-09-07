package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
import com.bean.Student;
import com.bean.TrainerStudent;

@Repository
public class EmployeeDao {

	// Below is without JPA
	/*
	@Autowired
	DataSource ds;
	
	public Employee getEmployeeInfo(int id) {
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				
				return emp;
			}
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int storeEmployeeInfo(Employee emp) {
		
		try {
			  Connection con = ds.getConnection();
			  PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			  ps.setInt(1, emp.getId());
			  ps.setString(2, emp.getName());
			  ps.setFloat(3, emp.getSalary());
			  
			  int res = ps.executeUpdate();
			  
			  return res;
			  
		}catch (Exception e) {
          System.out.println(e.getMessage());
		}
		return 0;		
		
	}
	
	public int updateEmployeeInfo(Employee emp) {
		
		try {
			  Connection con = ds.getConnection();
			  PreparedStatement ps = con.prepareStatement("update employee set salary=salary +? where id=?");
			  
			  ps.setFloat(1, emp.getSalary());
			  ps.setInt(2, emp.getId());			  
			  
			  int res = ps.executeUpdate();
			  
			  return res;
			  
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		return 0;
				
	}
	
	public int deleteEmployeeInfo(int id) {
		
		try {
			  Connection con = ds.getConnection();
			  PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
			  
			  ps.setInt(1, id);			  
			  
			  int res = ps.executeUpdate();
			  
			  return res;
			  
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		return 0;
				
	}
	
	*/
	
// Below part written with JPA
	
	@Autowired
	EntityManager manager;  // ---> Use when no txn. management as it's by default singleton
	
//	@Autowired
//	EntityManagerFactory emf;
	
	
public int deleteStudentInfoById(int stdId) {
		
		Student std = manager.find(Student.class, stdId);
		if(std!=null) {
			manager.remove(std);
			return 1;
		}
		return 0;
	}

	public List<Employee> getEmployeeInfo(){
		
	//	EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select e from Employee e");
		List<Employee> listOfEmp = qry.getResultList();
		return listOfEmp;
	}
	
	
	public List<TrainerStudent> getTrainerStudentInfo(){
		
		List<TrainerStudent> list = new ArrayList<TrainerStudent>();
		
	//	EntityManager manager = emf.createEntityManager();
		Query qry = manager.createNativeQuery("select t.tname, t.rech, s.sname, s.age from trainer t, student s where t.tid=s.tsid");
		List<?>  listOfRec = qry.getResultList();
		ListIterator<?> ll = listOfRec.listIterator();
		while(ll.hasNext()) {
			Object obj[] = (Object[])ll.next();
			TrainerStudent ts = new TrainerStudent();
			ts.setTrainerName(String.valueOf(obj[0]));
			ts.setTrainerTech(String.valueOf(obj[1]));
			ts.setStudentName(String.valueOf(obj[2]));
			ts.setStudentAge(Integer.parseInt(String.valueOf(obj[3])));
			list.add(ts);
		}
		
		return list;
		
	}
	
// Code for txn. management	
	public String storeEmployeeInfo(Employee emp) {
		
//		EntityManager manager = emf.createEntityManager();   //--->Use it when emf created else start with manager directly.
//		EntityTransaction tran = manager.getTransaction();
//		tran.begin();			//---> Added Transactional at service layer so commented here.
			manager.persist(emp);
//		tran.commit();		//---> Added Transactional at service layer so commented here.
			
			Employee e = manager.find(Employee.class, emp.getId());
			if(e != null) {
				return "Record Stored";
			}else {
				return "Record not stored";
			}
		
	}
	
}
