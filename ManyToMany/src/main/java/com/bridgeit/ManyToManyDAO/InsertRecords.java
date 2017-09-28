package com.bridgeit.ManyToManyDAO;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.ManyToManyDTO.Course;
import com.bridgeit.ManyToManyDTO.Student;
import com.bridgeit.SingleTon.SingleTonSF;

public class InsertRecords {

	public static void main(String[] args) {

		SessionFactory sf = SingleTonSF.getSF();
		Session sess = sf.openSession();

		Student std1 = new Student();
		std1.setStudentId((short) 100);
		std1.setStudentName("S N Rao");
		std1.setMarks((short) 45);

		Student std2 = new Student();
		std2.setStudentId((short) 101);
		std2.setStudentName("Jyostna");
		std2.setMarks((short) 75);

		Course course1 = new Course();
		course1.setCourseId((short) 1234);
		course1.setCourseName("Java");
		course1.setDuration("60 days");

		Course course2 = new Course();
		course2.setCourseId((short) 5678);
		course2.setCourseName("Spring");
		course2.setDuration("30 days");

		Set set1 = new HashSet();
		set1.add(course1);
		set1.add(course2);

		std1.setCourses(set1);
		std2.setCourses(set1);

		Transaction tx = sess.beginTransaction();
		sess.save(std1);
		sess.save(std2);

		tx.commit();
		sess.close();
		sf.close();
		System.out.println("Many To Many Done.");
	}
}
