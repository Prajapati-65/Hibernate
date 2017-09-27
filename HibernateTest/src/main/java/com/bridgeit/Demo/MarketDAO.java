package com.bridgeit.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MarketDAO {

	public static void main(String[] args) {

		MarketDTO market = new MarketDTO();
		market.setShopName("abc");
		market.setMarketName("Super Market");
		market.setNoOfShop(10);
		try 
		{
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			SessionFactory sf = config.buildSessionFactory();
			Session session = sf.openSession();
			session.save(market);
			Transaction tx = session.beginTransaction();
			tx.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
