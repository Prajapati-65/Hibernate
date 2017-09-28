package com.bridgeit.ManyToOneDAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.ManyToOneDTO.Dept;
import com.bridgeit.ManyToOneDTO.Employee;
import com.bridgeit.SingleTon.SingleTonSF;

public class InsertRecards {

	public static void main(String[] args) {
		
		SessionFactory sf = SingleTonSF.getSF();
		Session s = sf.openSession();
		
		Dept d1 = new Dept();
	    d1.setDeptId(4567);
	    d1.setDeptName("Stores");
	 
	    Employee e1= new Employee();
	    e1.setEmployeeId(100);
	    e1.setEmployeeName("S N Rao");
	    e1.setMyDept(d1);
	 
	    Employee e2= new Employee();
	    e2.setEmployeeId(101);
	    e2.setEmployeeName("Sridhar");
	    e2.setMyDept(d1);
	 
	    Employee e3 = new Employee();
	    e3.setEmployeeId(102);
	    e3.setEmployeeName("Jyostna");
	    e3.setMyDept(d1);
	 
	    Transaction tx = s.beginTransaction();
	    s.save(e1);  
	    s.save(e2);
	    s.save(e3);
	 
	    tx.commit();
	    s.close();
	    
	    System.out.println("----------Many to one completed inserted --------");
	    sf.close();
	  }
}
