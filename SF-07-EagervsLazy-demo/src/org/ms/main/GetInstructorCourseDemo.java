package org.ms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.Course;
import org.ms.entities.Instructor;
import org.ms.entities.InstructorDetail;


public class GetInstructorCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//get the instructor
			int theId=2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor:" + tempInstructor);
		
			//get courses for the instructor
			System.out.println("Courses:" + tempInstructor.getCourses());
			
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
