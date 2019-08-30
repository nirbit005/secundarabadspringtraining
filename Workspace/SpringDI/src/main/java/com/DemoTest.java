package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		//Employee emp = new Employee();
		//emp.display();
		//Load the XML File and reference of ApplicationContext interface. 
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee emp = (Employee)ac.getBean("emp2");
		System.out.println(emp);
	}

}
