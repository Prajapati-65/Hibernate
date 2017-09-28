package com.bridgeit.SingleTon;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTonSF {

	private SingleTonSF() {

	}

	public static SessionFactory sf;

	public static SessionFactory getSF() {
		if (sf == null) {
			Configuration c = new Configuration();
			c.configure("hibernate.cfg.xml");
			sf = c.buildSessionFactory();
			return sf;
		}
		return sf;
	}

}
