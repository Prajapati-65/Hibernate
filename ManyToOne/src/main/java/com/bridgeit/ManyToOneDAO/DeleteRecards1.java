package com.bridgeit.ManyToOneDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.ManyToOneDTO.Employee;
import com.bridgeit.SingleTon.SingleTonSF;

public class DeleteRecards1 {

	public static void main(String[] args) {
		
		SessionFactory sf = SingleTonSF.getSF();
		Session s = sf.openSession();
		
		Employee e1 = (Employee) s.get(Employee.class, 100);
		Transaction tx = s.beginTransaction();
		s.delete(e1);
		System.out.println("Records is delete ");
		tx.commit();
		
	}
}
