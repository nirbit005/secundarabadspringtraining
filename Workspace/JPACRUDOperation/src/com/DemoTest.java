package com;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DemoTest {

	public static void main(String[] args) {
									
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACRUDOperation");
		EntityManager manager = emf.createEntityManager();
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Rajesh");
		emp.setSalary(16000);
		EntityTransaction tran = manager.getTransaction();
		//Insert Records 
		/*tran.begin();
							manager.persist(emp);
		tran.commit();
		System.out.println("Record inserted successfully...");*/
		//Delete Record 
		/*Employee emp1 = manager.find(Employee.class, 100);
		if(emp1!=null) {
						tran.begin();
									manager.remove(emp1);
						tran.commit();
						System.out.println("Record deleted successfully");
		}else {
				System.out.println("Record is not present");
		}*/
		//Update Record 
		/*
		Employee emp1 = manager.find(Employee.class, 102);
		if(emp1!=null) {
						tran.begin();
									emp1.setSalary(emp1.getSalary()+500);
									manager.merge(emp1);
						tran.commit();
						System.out.println("Record updated successfully");
		}else {
				System.out.println("Record is not present");
		}
		*/
		//Retrieve One REcords 
		/*Employee emp1 = manager.find(Employee.class, 102);
		if(emp1!=null) {
		System.out.println("Id is "+emp1.getId()+"Name is "+emp1.getName()+" Salary is "+emp1.getSalary());
		}else {
				System.out.println("Record is not present");
		}*/
		//Retrieve more than one records 
//Query qry = manager.createQuery("select e from Employee e where e.salary > 30000");
/*Query qry = manager.createQuery("select e from Employee e where e.salary > :sal");		
qry.setParameter("sal", 30000);
		List<?>	listOfRec = qry.getResultList();
		ListIterator<?> ll = listOfRec.listIterator();
		while(ll.hasNext()) {
			Employee e = (Employee)ll.next();
			System.out.println("Id is "+e.getId()+"Name is "+e.getName()+" Salary is "+e.getSalary());
		}
	*/
		//Retrieve Specific property but only one 
		/*Query qry = manager.createQuery("select e.name from Employee e");
		List<?>	listOfRec = qry.getResultList();
		ListIterator<?> ll = listOfRec.listIterator();
		while(ll.hasNext()) {
			String name = (String)ll.next();
			System.out.println("Name is "+name);
		}*/
		
		//Retrieve more than one property  
		/*		Query qry = manager.createQuery("select e.name,e.salary from Employee e");
				List<?>	listOfRec = qry.getResultList();
				ListIterator<?> ll = listOfRec.listIterator();
				while(ll.hasNext()) {
					Object obj[]=(Object[])ll.next();
					System.out.println("Name is "+obj[0]+" Salary "+obj[1]);
				}
				*/
			//Retreive records using native sql query with join concept. 
/*Query qry = 
manager.createNativeQuery("select t.tname,t.tech,s.sname,s.age from trainer t, student s where t.tid= s.tsid");
List<?> listOfRec = qry.getResultList();
ListIterator<?> ll = listOfRec.listIterator();
while(ll.hasNext()) {
	Object obj[]=(Object[])ll.next();
	System.out.println("Trainer name "+obj[0]+" Tech "+obj[1]+" Student "+obj[2]+" Age "+obj[3]);
}*/
		
		Trainer t1= new Trainer();
		Student s1 = new Student();
		Student s2= new Student();
		s1.setSid(105);	s1.setSname("Mahesh"); s1.setAge(26); s1.setTsid(3);
		s2.setSid(106);	s2.setSname("Vijay"); s2.setAge(28); s2.setTsid(3);
		List<Student> listOfStd = new ArrayList<Student>();
		listOfStd.add(s1); listOfStd.add(s2);
		t1.setTid(3); t1.setTname("Ram"); t1.setTech("HTML5"); 
		t1.setListOfStd(listOfStd);
		//Store Records 
		tran.begin();
						manager.persist(t1);
					//	manager.persist(s1);
					//	manager.persist(s2);
		tran.commit();
		System.out.println("Record saved successfully....");
 	}

}


