package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
/*Employee emp = (Employee)ac.getBean("emp");
System.out.println(emp);
emp.setId(1);
emp.setName("Ravi");
Address add = emp.getAdd();
add.setCity("Bangalore");
add.setState("Kar");
emp.setAdd(add);
System.out.println(emp);
*/
Address add = (Address)ac.getBean("add");
add.setCity("Bangalore");
add.setState("Kar");
AddressDao ad = (AddressDao)ac.getBean("addressDao");
	int res = ad.storeAddressInfo(add);
	if(res>0) {
		System.out.println("REcord stored");
	}else {
		System.out.println("REcod not store");
	}
	}

}
