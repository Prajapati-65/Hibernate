package com.bridgeit.OneTOOneDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.OneToOneDTO.Address;
import com.bridgeit.OneToOneDTO.Student;
import com.bridgeit.SingleTon.SingleTonSF;

public class InsertRecords {

	public static void main(String[] args) {
		
		SessionFactory sf =SingleTonSF.getSF();
		Session s = sf.openSession();
	    Transaction t = s.beginTransaction();

	    Student s1 = new Student(0,"S N Rao");
	    Address a1 = new Address("100","15","Jawahar Nagar1","Hyderabad",s1);

	    Student s2 = new Student(0,"S P Yadav");
	    Address a2 = new Address("200","20","Jawahar Nagar2","Bangalore",s2);
	    
	    s.save(a1);
	    s.save(a2);
	    s.flush();
	    t.commit();
	    System.out.println("----------------");
	    System.out.println("Record of " + s1.getSid() + " is inserted");
	}
}
