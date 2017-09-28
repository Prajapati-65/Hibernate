package com.bridgeit.Pooja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BridgeitDAO {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Bridgeit.class);
		
		SessionFactory sf=config.buildSessionFactory();
		Session sess=sf.openSession();
		
		

	}
}
