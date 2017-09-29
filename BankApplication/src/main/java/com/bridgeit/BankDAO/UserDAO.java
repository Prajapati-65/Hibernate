package com.bridgeit.BankDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.bridgeit.BankDTO.UserDTO;
import com.bridgeit.SingleTon.SingleTonSF;

public class UserDAO {
	
	
	public UserDTO loginUser(String email, String password) {
		
		SessionFactory factory = SingleTonSF.getSF();
		Session session = factory.openSession();
		UserDTO user = null;

		String hql = "select from registration where email=? and password = ?";
		Query<S> query = session.createQuery(hql);
		query.setString("email", email);
		query.setString("password", password);
		user = (UserDTO) query.uniqueResult();
		session.close();
		return user;	
	}
}
