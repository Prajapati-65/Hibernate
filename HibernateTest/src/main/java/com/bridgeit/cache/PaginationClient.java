package com.bridgeit.cache;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgeit.Demo.MarketDTO;

public class PaginationClient {
	
	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		List<MarketDTO> result = null;
		try {
			Query q = s.createQuery("from market_table");
			q.setFirstResult(0);
			q.setMaxResults(2);
			//result = q.list();

			Iterator<MarketDTO> it = result.iterator();
			while (it.hasNext()) {
				MarketDTO std = (MarketDTO) it.next();
				System.out.println(std.getShopNum() + "  " + std.getShopName() + "  " + std.getMarketName() + " "
						+ std.getNoOfShop());
			}

			q.setFirstResult(2);
			q.setMaxResults(3);
			//result = q.list();

			for (MarketDTO std : result) {
				System.out.println(std.getShopNum() + "  " + std.getShopName() + "  " + std.getMarketName() + " "
						+ std.getNoOfShop());
			}

			q.setFirstResult(5);
			//result = q.list();

			for (MarketDTO std : result) {
				System.out.println(std.getShopNum() + "  " + std.getShopName() + "  " + std.getMarketName() + " "
						+ std.getNoOfShop());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}