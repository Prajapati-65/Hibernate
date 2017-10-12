package com.bridgeit.BankDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgeit.BankDTO.AccountDTO;
import com.bridgeit.BankDTO.UserDTO;
import com.bridgeit.SingleTon.SingleTonSF;

public class BankDAO {

	final static Logger logger = LoggerFactory.getLogger(BankDAO.class);

	/**
	 * @param String
	 *            email
	 * @return Integer
	 */
	public static int id(String email) {
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		int id = 0;
		try {
			Criteria c = session.createCriteria(UserDTO.class);
			c.add(Restrictions.eq("email", email));
			UserDTO user = (UserDTO) c.uniqueResult();
			id = user.getId();
			logger.debug("return id ");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Thraws Exceptions");
		}
		return id;
	}

	/**
	 * @param AccountDTO
	 *            account
	 * @return Integer
	 */
	public static int saveAccountData(AccountDTO account) {
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int status = 0;
		try {
			transaction = session.beginTransaction();
			status = (int) session.save(account);
			transaction.commit();
			status = 1;
			logger.info("Your data is save");
			return status;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Throws Exception");
		} finally {
			try {
				if (session != null)
					session.close();

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Throws Exception");
			}
		}
		return status;
	}

	/**
	 * @param String
	 *            city
	 * @param Integer
	 *            userId
	 * @return List list
	 */
	public static List<AccountDTO> getAllAccount(String city, int userId) {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		UserDTO user = new UserDTO();
		user.setId(userId);
		try {
			Criteria c = session.createCriteria(AccountDTO.class);
			c.add(Restrictions.eq("city", city));
			c.add(Restrictions.eq("user", user));
			list = c.list();
			logger.info("Get all data");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Throws Exception");
		}
		return list;
	}

	public static int deleteAccount(int id) {
		System.out.println("----- Inside delete function-----");
		SessionFactory factory = SingleTonSF.getSF();
		Session session = factory.openSession();
		Transaction transaction = null;
		int status = 0;
		try {
			transaction = session.beginTransaction();
			AccountDTO account = new AccountDTO();
			account.setId(id);
			session.delete(account);
			logger.info("Data is deleted");
			transaction.commit();
			status = 1;
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("throws exception");
		}

		return status;
	}

	/**
	 * @param Integer
	 *            id
	 * @return JSONObject object
	 */
	public static JSONObject updateAccount(int id) {
		JSONObject object = new JSONObject();
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(AccountDTO.class);
		criteria.add(Restrictions.eq("id", id));
		List result = criteria.list();
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			AccountDTO user = (AccountDTO) iterator.next();
			object.put("id", user.getId());
			object.put("name", user.getName());
			object.put("email", user.getEmail());
			object.put("city", user.getCity());
			object.put("accountnumber", user.getAccountnumber());
			JSONArray array = new JSONArray();
			array.add(object);
		}
		session.close();
		return object;
	}

	/**
	 * @param Integer
	 *            id
	 * @param String
	 *            name
	 * @param String
	 *            email
	 * @param String
	 *            city
	 * @param String
	 *            accountnumber
	 */
	public static void editRow(int id, String name, String email, String city, String accountnumber) {
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		AccountDTO account = (AccountDTO) session.get(AccountDTO.class, id);
		account.setName(name);
		System.out.println("dfgfdg--" + name);
		account.setEmail(email);
		account.setCity(city);
		account.setAccountnumber(accountnumber);
		session.update(account);
		logger.info("Data updated");
		transaction.commit();
		session.close();
		logger.warn("session close");
	}

}
