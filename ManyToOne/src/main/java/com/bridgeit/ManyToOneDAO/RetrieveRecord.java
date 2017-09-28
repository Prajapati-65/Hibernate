package com.bridgeit.ManyToOneDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bridgeit.ManyToOneDTO.Dept;
import com.bridgeit.ManyToOneDTO.Employee;
import com.bridgeit.SingleTon.SingleTonSF;

public class RetrieveRecord {

	public static void main(String[] args) {

		SessionFactory sf = SingleTonSF.getSF();
		Session session = sf.openSession();

		Employee e1 = (Employee) session.get(Employee.class, 100);
		System.out.println("--------Employee Details---------");
		System.out.println("Employee ID:--> " + e1.getEmployeeId());
		System.out.println("Employee Name:--> " + e1.getEmployeeName());
		System.out.println();
		Dept d1 = e1.getMyDept();
		System.out.println("--------Employee Department Details---------");
		System.out.println("Employee Department ID:--> " + d1.getDeptId());
		System.out.println("Employee Department Name:--> " + d1.getDeptName());

		session.close();
		System.out.println("many to one select is completed");
		sf.close();
	}
}
