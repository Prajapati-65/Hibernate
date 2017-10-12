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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgeit.BankDTO.UserDTO;
import com.bridgeit.SingleTon.SingleTonSF;

public class UserDAO {

	final static Logger logger = (Logger) LoggerFactory.getLogger(UserDAO.class);

	/**
	 * @param email
	 * @param password
	 * @return UserDTO Object
	 */
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
			name = user.getName();
			logger.info("Login succesfully");
		}
		session.close();
		return user;
	}

	/**
	 * @param UserDOT user
	 * @return Integer
	 */
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
			logger.info("Registration successfully");
			return status;
		} catch (Exception ex) {
			logger.error("Throws excepation");
			ex.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Throws excepation");
			}
		}
		return status;
	}

}
