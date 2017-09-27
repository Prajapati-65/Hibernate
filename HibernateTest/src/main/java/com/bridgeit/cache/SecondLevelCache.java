package com.bridgeit.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgeit.Demo.MarketDTO;

public class SecondLevelCache {
	
	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();
		
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		
		MarketDTO market1 = (MarketDTO) session1.get(MarketDTO.class, 1);
		System.out.println("11111111");
		System.out.println(market1.getShopNum() + "--1--" + market1.getShopName() + "--2--" + market1.getMarketName()
				+ "--3--" + market1.getNoOfShop());

		MarketDTO market2 = (MarketDTO) session2.get(MarketDTO.class, 1);
		System.out.println(market2.getShopNum() + "--1--" + market2.getShopName() + "--2--" + market2.getMarketName()
				+ "--3--" + market2.getNoOfShop());
	}
}
