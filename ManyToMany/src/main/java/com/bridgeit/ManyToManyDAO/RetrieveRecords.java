package com.bridgeit.ManyToManyDAO;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bridgeit.ManyToManyDTO.Course;
import com.bridgeit.ManyToManyDTO.Student;
import com.bridgeit.SingleTon.SingleTonSF;

public class RetrieveRecords {

	public static void main(String[] args) {

		SessionFactory sf = SingleTonSF.getSF();
		Session sess = sf.openSession();

		Student std = (Student) sess.get(Student.class, 100);
		
		System.out.println("--> " + std.getStudentId() + ", " + std.getStudentName() + ", " + std.getMarks());

		Set<Course> mySet = std.getCourses();
		Iterator it = mySet.iterator();
		while (it.hasNext()) {
			Course c1 = (Course) it.next();
			System.out.println("--> " + c1.getCourseId() + ", " + c1.getCourseName() + ", " + c1.getDuration());
		}

		sess.close();
		sf.close();
	}
}
