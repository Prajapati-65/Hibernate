package com.bridgeit.BankDAO;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.bridgeit.BankDTO.UserDTO;
import com.bridgeit.SingleTon.SingleTonSF;

public class UserDAO {
	
	
	
	public static UserDTO loginUser(String email, String password) {
		String name = null;
		SessionFactory factory = SingleTonSF.getSF();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		Criterion emailVerify = Restrictions.ilike("email", email);
		Criterion passwordVerify = Restrictions.ilike("password", password);

		LogicalExpression andExp = Restrictions.and(emailVerify, passwordVerify);
		criteria.add(andExp);
		UserDTO user = null;
		List result = criteria.list();
		Iterator iterator = result.iterator(); 
		while (iterator.hasNext()) {
			 user = (UserDTO) iterator.next();
			System.out.println("user name is--> " + user.getName());
			name = user.getName();
		}
		session.close();
		return user;
	}
	
	public static int saveRegistration(UserDTO user) {
		SessionFactory factory = SingleTonSF.getSF();
		Session session = factory.openSession();
		Transaction transaction = null;
		int status = 0;
		try {
			transaction = session.beginTransaction();
			status = (int) session.save(user);
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

	

}
