package com.bridgeit.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.SingleTon.SingleTonSF;

public class TestDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = SingleTonSF.getSF();
		Session session=sf.openSession();
		
		PersonDTO per = new PersonDTO();
		per.setAge(20);
		per.setName("Om Prajapati");
		per.setLocation("Mumbai");
		
		AadharDTO adh = new AadharDTO();
		adh.setAddress("Mumbai");
		
		per.setAadhar(adh);
		AadharDTO adr1 = per.getAadhar();
		
		session.save(adr1);
		session.save(per);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		
	}
}
