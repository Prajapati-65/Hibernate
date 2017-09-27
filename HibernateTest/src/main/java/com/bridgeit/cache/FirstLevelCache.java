package com.bridgeit.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgeit.Demo.MarketDTO;

public class FirstLevelCache {

	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();

		Session session1 = sf.openSession();
		
		System.out.println("111111111");
		MarketDTO market1 = (MarketDTO)session1.get(MarketDTO.class, 1);
		System.out.println("------------");
		System.out.println(market1.getShopNum() + "--1--" + market1.getShopName() + "--2--" + market1.getMarketName()
				+ "--3--" + market1.getNoOfShop());
		
		Session session2 = sf.openSession();
		
		System.out.println("222222222");
		MarketDTO market2 = (MarketDTO) session2.get(MarketDTO.class, 1);
		System.out.println(market2.getShopNum() + "--1--" + market2.getShopName() + "--2--" + market2.getMarketName()
		+ "--3--" + market2.getNoOfShop());
		
		
		System.out.println("333333333");
		MarketDTO market3 = (MarketDTO) session2.get(MarketDTO.class, 2);
		System.out.println(market3.getShopNum() + "--1--" + market3.getShopName() + "--2--" + market3.getMarketName()
		+ "--3--" + market3.getNoOfShop());
	}
}
