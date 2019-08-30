package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	DataSource ds;
	public int storeEmployeeInfo(Employee emp) {
		try {
		Connection con = ds.getConnection();
PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
pstmt.setInt(1, emp.getId());		pstmt.setString(2, emp.getName()); 
pstmt.setFloat(3, emp.getSalary());
		int res = pstmt.executeUpdate();
		return res;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
}
