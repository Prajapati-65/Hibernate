package com.bridgeit.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bridgeit.SingleTon.SingleTonSF;

public class TestOneToMany {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();
		
		Country country = new Country();
		country.setName("India");
		country.setPopulation(1300000000);
		
		States state1 = new States();
		state1.setName("UP");
		state1.setCapital("Lucknow");
		
		States state2 = new States();
		state2.setName("MP");
		state2.setCapital("Bhopal");
		

		States state3 = new States();
		state3.setName("MH");
		state3.setCapital("Mumbai");
		
		
		List<States> states=new ArrayList<>();
		states.add(state1);
		states.add(state2);
		states.add(state3);
		
		country.setStates(states);
		
		
		session.save(state1);
		session.save(state2);
		session.save(state3);
		session.save(country);
		
		
		session.beginTransaction().commit();
	}

}
