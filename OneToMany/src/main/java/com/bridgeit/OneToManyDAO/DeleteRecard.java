package com.bridgeit.OneToManyDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.OneToMany.Dept;
import com.bridgeit.SingleTon.SingleTonSF;

public class DeleteRecard { 
	

	public static void main(String args[]) {

		SessionFactory sf = SingleTonSF.getSF();
		Session session = sf.openSession();
		
		Dept d1 = (Dept) session.get(Dept.class, new Integer(1234));
		
		Transaction tx = session.beginTransaction(); 
		session.delete(d1);
		
		tx.commit();

		session.close();

		System.out.println("One To Many deletion is over");
		
		sf.close();
	}
}
