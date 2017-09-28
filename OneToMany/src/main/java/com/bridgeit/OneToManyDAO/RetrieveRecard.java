package com.bridgeit.OneToManyDAO;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bridgeit.OneToMany.Dept;
import com.bridgeit.OneToMany.Employee;
import com.bridgeit.SingleTon.SingleTonSF;

public class RetrieveRecard {

	public static void main(String args[]) {

		SessionFactory sf = SingleTonSF.getSF();

		Session session = sf.openSession();

		Dept d1 = session.get(Dept.class, 1234);
		
		System.out.println("Dept Id--> "+d1.getDeptId() + "\nDept Name--> " + d1.getDeptName());
		
		System.out.println("------------Employee records:--------------");
		Set mySet = d1.getEmployees();
		Iterator it = mySet.iterator();
		while (it.hasNext()) 
		{
			Employee emp = (Employee) it.next();
			System.out.println(emp.getEmployeeId() + " " + emp.getEmployeeName());
		}
		session.close();

		
		System.out.println("Thank you, One To Many is Done");
		sf.close();
	}
}
