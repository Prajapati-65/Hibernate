package com.bridgeit.OneToManyDAO;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.OneToMany.Dept;
import com.bridgeit.OneToMany.Employee;
import com.bridgeit.SingleTon.SingleTonSF;

public class InsertRecard {

	public static void main(String[] args) {

		SessionFactory sf = SingleTonSF.getSF();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Employee emp1 = new Employee();
		emp1.setEmployeeId(1);
		emp1.setEmployeeName("S N Rao");

		Employee emp2 = new Employee();
		emp2.setEmployeeId(2);
		emp2.setEmployeeName("Sumathi");

		Employee emp3 = new Employee();
		emp3.setEmployeeId(3);
		emp3.setEmployeeName("Sasi");

		Employee emp4 = new Employee();
		emp4.setEmployeeId(4);
		emp4.setEmployeeName("Om");

		Employee emp5 = new Employee();
		emp5.setEmployeeId(5);
		emp5.setEmployeeName("Siddu");

		Set<Employee> emps = new HashSet<Employee>();
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);

		Dept dept1 = new Dept();
		dept1.setDeptId(1234);
		dept1.setDeptName("Production");

		dept1.setEmployees(emps);
		session.persist(dept1);

		trans.commit();

		System.out.println("------Records Inserted-------");
	}

}
