package com.bridgeit.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetLoadDeleteUpdate {

	public static void main(String rags[]) throws Exception {
		
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		
		Object obj = s.get(MarketDTO.class, 1);
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

		Object obj2 = s.get(MarketDTO.class, 2);
		if (obj2 != null) {
			System.out.println(obj.getClass().getName());
			MarketDTO s2 = (MarketDTO) obj2;

			System.out.println(s2.getShopNum());
			System.out.println(s2.getShopName());
			System.out.println(s2.getMarketName());
			System.out.println(s2.getNoOfShop());
		} else {
			System.out.println("Record does not exist");
		}

		Object obj3 = s.get(MarketDTO.class, 3);
		if (obj != null) {
			System.out.println(obj.getClass().getName());
			MarketDTO s3 = (MarketDTO) obj3;

			System.out.println(s3.getShopNum());
			System.out.println(s3.getShopName());
			System.out.println(s3.getMarketName());
			System.out.println(s3.getNoOfShop());
		} else {
			System.out.println("Record does not exist");
		}
		
		Transaction tx = s.beginTransaction();
		Object obj4 = s.load(MarketDTO.class, 4);
		MarketDTO s4 = (MarketDTO) obj4;
		s.delete(s4);
		tx.commit();
		System.out.println("4 record is deleted");
		
		
		Transaction tx1 = s.beginTransaction();
		MarketDTO market5 = s.load(MarketDTO.class, 3);
		market5.setShopName("Abcom");
		market5.setMarketName("Super Market 1");
		s.update(market5);
		tx1.commit();
		System.out.println("3 record is updated");
	}
}