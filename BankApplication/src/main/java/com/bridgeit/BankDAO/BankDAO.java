package com.bridgeit.BankDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeit.BankDTO.AccountDTO;
import com.bridgeit.BankDTO.UserDTO;
import com.bridgeit.SingleTon.SingleTonSF;

public class BankDAO {

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
			return status;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static int deleteAccount(int id) {
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		int status = 0;
		try {
			String hql = "delete from AccountDTO where id = ?";
			Query<UserDTO> query = session.createQuery(hql);
			query.setInteger("id", id);
			query.uniqueResult();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int id(String email) {
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		int id=0;
		try {
			Criteria  c = session.createCriteria(UserDTO.class);
			c.add(Restrictions.eq("email", email));
			UserDTO user = (UserDTO) c.uniqueResult();
			id = user.getId();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public static List<AccountDTO> getAllAccount(String city, int userId) {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		try {
			Criteria c = session.createCriteria(AccountDTO.class);
			c.add(Restrictions.eq("city", city));
			c.add(Restrictions.eq("userId", userId));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

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

	public static void editAccount(int id) {
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update AccountDTO  set name=?, email=? ,city=?, accountnumber=? where id=?";
		AccountDTO account = (AccountDTO) session.get(AccountDTO.class, id);
		transaction.commit();
		session.update(account);
		session.close();
	}

}
