package com;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AddressDao {
	@Autowired
	DataSource ds;
	public int storeAddressInfo(Address add) {
		try {
			Connection con  = ds.getConnection();
			PreparedStatement pstmt = 
					con.prepareStatement("insert into address values(?,?)");
			pstmt.setString(1, add.getCity());
			pstmt.setString(2,add.getState());
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {
					System.out.println(e);
		}
		return 0;
	}
}
