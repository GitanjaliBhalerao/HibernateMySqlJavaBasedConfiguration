package com.ttl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ttl.dao.StudentDao;
import com.ttl.entity.Student;
import com.ttl.util.HibernateUtil;

public class Application {

	public static void main(String[] args) throws IllegalStateException {
		// TODO Auto-generated method stub

		Student s1 = new Student("Sachin", "Tendulkar", "sachin@ttl.com");
		Student s2 = new Student("Virat", "Kohli", "virat@ttl.com");

		
		StudentDao studentDao=new StudentDao();
		studentDao.saveStudent(s1);
		studentDao.saveStudent(s2);
		
		List<Student> students=studentDao.getAllStudents();
		
		System.out.println(students);
		
		
		/*Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = (Transaction) session.beginTransaction();
			// save the student objects
			session.persist(s1);
			session.persist(s2);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}*/

	}

}
