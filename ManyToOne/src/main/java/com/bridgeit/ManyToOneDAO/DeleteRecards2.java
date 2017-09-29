package com.bridgeit.ManyToOneDAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.ManyToOneDTO.Dept;
import com.bridgeit.ManyToOneDTO.Employee;
import com.bridgeit.SingleTon.SingleTonSF;

public class DeleteRecards2 {

	public static void main(String[] args) {

		SessionFactory sf = SingleTonSF.getSF();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Query q = s.createQuery("FROM Employee");

	/*
		
		
		Employee e1 = null;
		Iterator it = q.iterate();
		while (it.hasNext()) {
			e1 = (Employee) it.next();
			s.delete(e1);
		}
		Dept d1 = e1.getMyDept();
		s.delete(d1);

		
		
	
		*/
		
		tx.commit();
		s.close();
		System.out.println("Deletion is done successfully");
		sf.close();
	}

}
