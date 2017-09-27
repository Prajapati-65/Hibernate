package com.bridgeit.Demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetLoadDeleteUpdate1 {

	public static void main(String rags[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to display the database");
		int first = sc.nextInt();

		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Object obj = s.get(MarketDTO.class, first);
		if (obj != null) {
			
			System.out.println(obj.getClass().getName());
			MarketDTO s1 = (MarketDTO) obj;
			System.out.println(s1.getShopNum());
			System.out.println(s1.getShopName());
			System.out.println(s1.getMarketName());
			System.out.println(s1.getNoOfShop());
		} else {
			System.out.println("Record does not exist");
		}


		System.out.println("-----------------------------");
		System.out.println("Enter 2 to delete the database");
		int second = sc.nextInt();
		Transaction tx = s.beginTransaction();
		Object obj4 = s.load(MarketDTO.class, second);
		MarketDTO s4 = (MarketDTO) obj4;
		s.delete(s4);
		tx.commit();
		System.out.println("record is deleted");

	
		System.out.println("------------------------------");
		System.out.println("Enter 3 to update the database");
		int three = sc.nextInt();
		Transaction tx1 = s.beginTransaction();
		Object obj5 = s.load(MarketDTO.class, three);
		MarketDTO s5 = (MarketDTO) obj5;
		s5.setShopName("Abc");
		s5.setMarketName("Super Market");
		s.update(s5);
		tx1.commit();
		System.out.println("record is updated");
	}
}