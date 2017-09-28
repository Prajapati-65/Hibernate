package com.bridgeit.ManyToManyDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.ManyToManyDTO.Student;
import com.bridgeit.SingleTon.SingleTonSF;

public class DeleteRecords {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Student std = session.load(Student.class, 100);
		session.delete(std);

		transaction.commit();
		System.out.println("Records deleted.");
		session.close();
		sessionFactory.close();
	}
}
