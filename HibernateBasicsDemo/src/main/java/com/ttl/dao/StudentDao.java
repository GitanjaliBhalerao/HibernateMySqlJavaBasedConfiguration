package com.ttl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ttl.entity.Student;
import com.ttl.util.HibernateUtil;

public class StudentDao {
	
	public void saveStudent(Student student)
	{
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			//start transaction
			transaction=session.beginTransaction();
			
			//persist
			session.persist(student);
			
			transaction.commit();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public List<Student> getAllStudents()
	{
		List<Student> all_Students=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			all_Students=session.createQuery("from Student",Student.class).list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return all_Students;
	}

}
